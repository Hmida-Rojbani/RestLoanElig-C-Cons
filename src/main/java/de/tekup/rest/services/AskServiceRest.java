package de.tekup.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;

@Service
public class AskServiceRest {
	
	private static final String BASE_URL="http://localhost:8080";
	private RestTemplate template = new RestTemplate();
	
	@Autowired
	private FeignCallerClient client;

	public WsResponse sendRequestToServer(CustomerRequest request) {
		WsResponse response = template.postForObject(BASE_URL+"/check/client/status",
				request, WsResponse.class);
		
		return response;
	}
	
	public WsResponse sendRequestToServerFeign(CustomerRequest request) {
		
		 WsResponse  response = client.callService(request);
		
		return response;
	}

}
