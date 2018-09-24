package com.reviewapp.util;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class TokenUtil {
	
	public String generateToken (Long userId) {
		
		//Using userId and timestamp to generate unique data...
		String target = userId + '.'+ String.valueOf(new Date().getTime());
		
		//Hashing the data using SHA256 Algorithm to generate unique token....
		String token = Hashing.sha256().hashString(target, StandardCharsets.UTF_8).toString();
		return token;
	}
}
