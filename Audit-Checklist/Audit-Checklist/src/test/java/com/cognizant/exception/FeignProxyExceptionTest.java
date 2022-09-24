package com.cognizant.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 
 * This class test the FeignProxyException class
 * 
 *
 */
@ExtendWith(SpringExtension.class)@ContextConfiguration
public class FeignProxyExceptionTest{
	
	
	
	@Mock
	FeignProxyException feignProxyException;
	
	@Test
	public void contextLoads() {
		assertNotNull(feignProxyException);
	}
	
	@Test 
	public void testConstructor() {
		
		assertNotNull(new FeignProxyException());
	}

}
