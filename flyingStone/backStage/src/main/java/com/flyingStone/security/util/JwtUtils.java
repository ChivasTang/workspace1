package com.flyingStone.security.util;

import java.io.Serializable;
import java.security.Principal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.flyingStone.security.constant.SecurityConstants;
import com.flyingStone.security.domain.JwtUser;

@Slf4j
public class JwtUtils implements Serializable {

    private static final long serialVersionUID = -843431674050899100L;

    /**
     * Tokenを作成
     *
     * @param userDetails ユーザ情報
     * @return Token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(Claims.SUBJECT, userDetails.getUsername());
        claims.put(Claims.ISSUED_AT, new Date());
        return generateToken(claims);
    }

    public String generateToken(Authentication authentication){
        Principal principal= (Principal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getName())
                .setIssuedAt(new Date())
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
                .compact();
    }

    /**
     * TokenからユーザIdを取得
     *
     * @param token Token
     * @return UserId
     */
    public Long getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    /**
     * Tokenからユーザ名を取得
     *
     * @param token Token
     * @return ユーザ名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * クレームによってTokenを作成
     *
     * @param claims クレーム
     * @return Token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    /**
     * 期限を取得
     *
     * @return Date
     */
    private Date getExpirationDate(){
        return Date.from(ZonedDateTime.now().plusHours(SecurityConstants.VALIDATE_HOUR).toInstant());
    }

    /**
     * Tokenからクレームを取得
     *
     * @param token Token
     * @return クレーム
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
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
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * Tokenを更新
     *
     * @param token 元Token
     * @return 新Token
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(Claims.ISSUED_AT, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * Tokenを検証
     *
     * @param token Token
     * @param userDetails ユーザ情報
     * @return true 有効 false 無効
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token);
            return true;
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
}
