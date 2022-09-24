package com.cognizant.service;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;
/**
 * This class contains test cases for the TokenServiceImpl class.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@Slf4j
public class TokenServiceImplTest {
	
	@InjectMocks
	TokenServiceImpl tokenService;
	@Mock
	AuthClient authClient;
	
	@Mock
	AuthResponse authResponse;
	@Mock
	Environment env;
	@Mock
	ResponseEntity<Boolean> entity;

	/**
	 * test to check the validity of token when token is valid 
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		log.info(env.getProperty("string.start"));
		entity = new ResponseEntity<Boolean>(HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		assertEquals(true, tokenService.checkTokenValidity("token"));
		log.info(env.getProperty("string.end"));

	}
	/**
	 * test to check the validity of token when token gives null pointer exception
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {
		log.info(env.getProperty("string.start"));

		assertThrows(NullPointerException.class,() -> tokenService.checkTokenValidity("token"));
		log.info(env.getProperty("string.end"));

	}
	/**
	 * test to check the validity of token when token is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		log.info(env.getProperty("string.start"));
		entity = new ResponseEntity<Boolean>(HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(entity);
		assertEquals(false, tokenService.checkTokenValidity("token"));
		log.info(env.getProperty("string.end"));
	}


}
