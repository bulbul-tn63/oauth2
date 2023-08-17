package com.tnpay.authorizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


@EnableFeignClients
@SpringBootApplication
public class AuthorizationServiceApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		// CODE VERIFIER
		SecureRandom secureRandom = new SecureRandom();
		byte [] code = new byte[32];
		secureRandom.nextBytes(code);
		String codeVerifier = Base64.getUrlEncoder()
				.withoutPadding()
				.encodeToString(code);


		// CODE CHALLENGE

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte [] digested = messageDigest.digest(codeVerifier.getBytes());
		String codeChallenge = Base64.getUrlEncoder()
				.withoutPadding()
				.encodeToString(digested);

		System.out.println("VERIFIER: " + codeVerifier);
		System.out.println("CHALLENGE: " + codeChallenge);
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	/**
	 * http://127.0.0.1:7676/oauth2/authorize?response_type=code&client_id=client&
	 * redirect_uri=http://127.0.0.1:8080/authorized&code_challenge=yD3P3-m5jQN5Pw2tHLDkVAljc36k8J_jgGHcJi-0tRY&code_challenge_method=S256
	 * */
}
