package com.whkxdk;

import com.whkxdk.service.DepteService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootDemoApplicationTests {
	@Autowired
	DepteService depteService;
	@Test
	void contextLoads() {
	}

	//生成Jwt令牌
	@Test
	void jwtUtiles(){
		Map<String,Object> claims= new HashMap<>();
		claims.put("id",1);
		claims.put("name","文豪");

       String jwt= Jwts.builder().
			   setClaims(claims).
			   signWith(SignatureAlgorithm.HS256,"kxdk" ).
			   setExpiration(new Date(System.currentTimeMillis()+3600*1000)).
			   compact();
		System.out.println(jwt);
	}
	@Test
	void aspectMy(){
		depteService.getDepteById(2);
	}

}
