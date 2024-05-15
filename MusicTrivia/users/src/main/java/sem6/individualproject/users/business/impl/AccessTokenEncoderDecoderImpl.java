package sem6.individualproject.users.business.impl;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sem6.individualproject.users.business.AccessTokenDecoder;
import sem6.individualproject.users.business.AccessTokenEncoder;
import sem6.individualproject.users.business.exception.InvalidAccessTokenException;
import sem6.individualproject.users.domain.AccessToken;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.util.*;
import java.time.chrono.HijrahChronology;

@Service
public class AccessTokenEncoderDecoderImpl implements AccessTokenEncoder, AccessTokenDecoder {
    private final Key key;

    public AccessTokenEncoderDecoderImpl(@Value("E91E158E4C6656F68B1B5D1C316766DE98D2AD6EF3BFB44F78E9CFCDF5") String secretKey){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    @Override
    public AccessToken decode(String accessTokenEncoded) {
        try {
            Jwt<?, Claims> jwt = Jwts.parser().verifyWith((SecretKey) key).build().parseSignedClaims(accessTokenEncoded);
            //Jwt<?, Claims> jwt = Jwts.parser().setSigningKey(key).build().parseClaimsJwt(accessTokenEncoded);
            Claims claims = (Claims) jwt.getBody();

            List<String> roles = claims.get("roles", List.class);

            return AccessToken.builder()
                    .subject(claims.getSubject())
                    .roles(roles)
                    .userId(claims.get("userId", Long.class))
                    .build();
        }catch (JwtException e){
            throw new InvalidAccessTokenException(e.getMessage());
        }
    }

    @Override
    public String encode(AccessToken accessToken) {
        Map<String, Object> claimsMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(accessToken.getRoles())){
            claimsMap.put("roles", accessToken.getRoles());
        }
        if (accessToken.getUserId() != null){
            claimsMap.put("userId", accessToken.getUserId());
        }

        /*Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(accessToken.getSubject())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30,ChronoUnit.MINUTES)))
                .addClaims(claimsMap)
                .signWith(key)
                .compact();*/

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        //Adding 30 min
        calendar.add(Calendar.MINUTE, 30);

        Date expirationDate = calendar.getTime();

        return Jwts
                .builder()
                .setSubject(accessToken.getSubject())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .addClaims(claimsMap)
                .signWith(key)
                .compact();
    }
}
