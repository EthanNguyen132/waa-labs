package edu.miu.waa.lab8.util;

import edu.miu.waa.lab8.model.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final GrantedAuthorityDefaults grantedAuthorityDefaults;

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    @Value("${app.jwt.expire.duration}")
    private long EXPIRE_DURATION;

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(user.getId() + "," + user.getEmail())
                .addClaims(Map.of("roles",
                        user.getUserRoles().stream().map(ur -> ur.getRole().getName()).toList()
                        )
                )
                .setIssuer("edu/miu/waa/lab8")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT " + e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("invalid JWT " + e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
}