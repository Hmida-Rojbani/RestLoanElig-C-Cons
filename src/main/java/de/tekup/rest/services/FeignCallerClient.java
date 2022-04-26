package de.tekup.rest.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;

@FeignClient(url = "http://localhost:8080",name = "http://localhost:8080")
public interface FeignCallerClient {
	
	@PostMapping("/check/client/status")
	public WsResponse callService(@RequestBody CustomerRequest request);

}
