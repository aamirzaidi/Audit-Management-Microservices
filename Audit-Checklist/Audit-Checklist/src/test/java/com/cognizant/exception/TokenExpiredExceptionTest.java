package com.cognizant.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration 
public class TokenExpiredExceptionTest {

	@Mock
	TokenExpiredException handler;
	
	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}
	
	@Test 
	public void testConstructor() {
		assertNotNull(new TokenExpiredException("Exception"));
	}
}
