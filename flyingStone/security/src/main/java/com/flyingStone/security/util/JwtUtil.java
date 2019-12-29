package com.flyingStone.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil implements Serializable {
    private static final long serialVersionUID = 470928112079029485L;

    private static final String CLAIM_KEY_USERNAME = "sub";
    // 5日
    private static final long EXPIRATION_TIME = 432000000;
    //JW
    private static final String SECRET = "secret";


    /**
     * JWTを発行
     *
     * @param userDetails ユーザ情報
     * @return jwt
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(Instant.now().toEpochMilli() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * tokenからusernameを取得
     * @param token token
     * @return username
     */
    public String getUserNameFromToken(String token){
        return getClaimsFromToken(token).getSubject();
    }

    /**
     * 解析JWT
     *
     * @param token token
     * @return claims
     */
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * tokenが期限切れかどうかを判断
     * @param token token
     * @return true 期限内,false期限切れ
     */
    public Boolean isNotExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.after(new Date());
    }

    /**
     * tokenの期限を取得
     *
     * @param token token
     * @return 期限
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }
}
