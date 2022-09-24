package com.cts.AuditSeverity.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 
 *
 */
@FeignClient(url = "${fos.auth}", name = "audit-auth")
public interface AuthClient {
	
	
	
	@PostMapping(value = "/auth/authorize")
	public ResponseEntity<Boolean> getValidity(@RequestHeader("Authorization") String token) ;


}

	
