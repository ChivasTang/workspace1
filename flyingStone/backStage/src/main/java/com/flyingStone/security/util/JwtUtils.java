package com.flyingStone.security.util;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;

import com.flyingStone.security.constant.SecurityConstants;
import com.flyingStone.security.domain.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JwtUtils implements Serializable {

    private static final long serialVersionUID = -843431674050899100L;

    /**
     * Tokenからユーザ情報を取得
     * @param token token
     * @return ユーザ情報
     */
    public JwtUser getJwtUserFromToken(String token){
        final Claims claims = getClaimsFromToken(token);
        final Long userId=getUserIdFromToken(token);
        final String username=claims.getSubject();
        final String email=getEmailFromToken(token);
        List<? extends GrantedAuthority> roles= (List<? extends GrantedAuthority>) claims.get(SecurityConstants.CLAIM_KEY_AUTHORITIES);
        Collection<? extends GrantedAuthority> authorities = parseArrayToAuthorities(roles);
        return new JwtUser(userId, username, email, null, authorities);
    }

    /**
     * RolesをAuthoritiesに解析
     *
     * @param roles roles
     * @return authorities
     */
    private Collection<? extends GrantedAuthority> parseArrayToAuthorities(List<? extends GrantedAuthority> roles) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority;
        for (Object role : roles) {
            authority = new SimpleGrantedAuthority(role.toString());
            authorities.add(authority);
        }
        return authorities;
    }

    /**
     * 認証情報によってTokenを作成
     *
     * @param authentication 認証情報
     * @return Token
     */
    public String generateToken(Authentication authentication){
        JwtUser user= (JwtUser) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setClaims(generateClaims(user))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(ZonedDateTime.now().plusHours(SecurityConstants.VALIDATE_HOUR).toInstant()))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
                .compact();
    }

    /**
     * ユーザ情報によってTokenを作成
     *
     * @param jwtUser JwtUser
     * @return token
     */
    public String generateToken(JwtUser jwtUser) {
        return Jwts.builder()
                .setSubject(jwtUser.getUsername())
                .setClaims(generateClaims(jwtUser))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(ZonedDateTime.now().plusHours(SecurityConstants.VALIDATE_HOUR).toInstant()))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
                .compact();
    }

    /**
     * Tokenからclaimsを取得
     *
     * @param token token
     * @return claims
     */
    private Claims getClaimsFromToken(String token){
        if(token==null){
            return null;
        }
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * TokenからユーザIdを取得
     *
     * @param token token
     * @return UserId
     */
    public Long getUserIdFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            //TODO
            log.error("Tokenが期限切れになりました。");
            throw new RuntimeException("Tokenが空です。");
        }
        return (Long) claims.get(SecurityConstants.CLAIM_KEY_USER_ID);
    }

    /**
     * TokenからユーザEmailを取得
     *
     * @param token token
     * @return Email
     */
    public String getEmailFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            //TODO
            log.error("Tokenが期限切れになりました。");
            throw new RuntimeException("Tokenが空です。");
        }
        return (String) claims.get(SecurityConstants.CLAIM_KEY_EMAIL);
    }

    /**
     * Tokenからユーザ名を取得
     *
     * @param token token
     * @return ユーザ名
     */
    public String getUsernameFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            //TODO
            log.error("Tokenが期限切れになりました。");
            throw new RuntimeException("Tokenが空です。");
        }
        return claims.getSubject();
    }

    /**
     *
     * @param token token
     * @param userDetails userDetails
     * @return true:有効 false:無効
     */
    public boolean validateToken(String token, UserDetails userDetails){
        JwtUser user=(JwtUser) userDetails;
        final long userId = getUserIdFromToken(token);
        final String username = getUsernameFromToken(token);
        return userId==user.getUserId()
                && username.equals(user.getUsername())
                && !isTokenExpired(token);
    }

    /**
     * Tokenを検証
     *
     * @param token token
     * @return true:有効 false:無効
     */
    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    /**
     * Tokenが期限切るかどうかを判断
     *
     * @param token Token
     * @return true 期限切 false 期限内
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            if(claims==null){
                //TODO
                log.error("Tokenが期限切れになりました。");
                throw new RuntimeException("Tokenが空です。");
            }
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * RequestからTokenを取得
     *
     * @param request request
     * @return token
     */
    public String getJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(SecurityConstants.TOKEN_HEADER);
        if(StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, SecurityConstants.TOKEN_PREFIX.length());
        }
        return null;
    }

    /**
     * Tokenをresponseに設定
     *
     * @param response response
     * @param token token
     */
    public void setJwtTokenToResponse(HttpServletResponse response,String token){
        response.setHeader(SecurityConstants.TOKEN_HEADER,token);
    }

    /**
     * Claimsを作成
     * @param user jwtUser
     * @return Claims
     */
    private Map<String, Object> generateClaims(JwtUser user){
        Map<String, Object> claims = new HashMap<>();
        claims.put(SecurityConstants.CLAIM_KEY_USER_ID, user.getUserId());
        claims.put(SecurityConstants.CLAIM_KEY_USER_NAME,user.getUsername());
        claims.put(SecurityConstants.CLAIM_KEY_EMAIL,user.getEmail());
        claims.put(SecurityConstants.CLAIM_KEY_AUTHORITIES,user.getAuthorities());
        return claims;
    }
}
