package com.cts.AuditSeverity.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cts.AuditSeverity.fiegnclient.AuthClient;
import com.cts.AuditSeverity.pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;
/**
 * This class contains test cases for the TokenServiceImpl class.
 */
//@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
@SpringBootTest
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
	 * this methods checks validity of token service and see if it is working or not
	 */
	@org.junit.Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		log.info(env.getProperty("string.start"));
		entity = new ResponseEntity<Boolean>(HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		Assert.assertEquals(true, tokenService.checkTokenValidity("token"));
		log.info(env.getProperty("string.end"));

	}
	/**
	 * This method checks if NullPOinter Exceptiomn is thrown or not
	 */
	@org.junit.Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {
		log.info(env.getProperty("string.start"));

		Assert.assertThrows(NullPointerException.class,() -> tokenService.checkTokenValidity("token"));
		log.info(env.getProperty("string.end"));

	}
	/**
	 * This methods checks acess is forbidden or not when token is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		log.info(env.getProperty("string.start"));
		entity = new ResponseEntity<Boolean>(HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(entity);
		Assert.assertEquals(false, tokenService.checkTokenValidity("token"));
		log.info(env.getProperty("string.end"));

	}


}
