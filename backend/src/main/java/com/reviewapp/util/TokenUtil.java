package com.reviewapp.util;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class TokenUtil {
	
	public String generateToken (Long userId) {
		String target = userId + '.'+ String.valueOf(new Date().getTime());
		String token = Hashing.sha256().hashString(target, StandardCharsets.UTF_8).toString();
		return token;
	}
}
