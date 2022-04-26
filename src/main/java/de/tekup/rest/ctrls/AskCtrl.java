package de.tekup.rest.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.rest.models.CustomerRequest;
import de.tekup.rest.models.WsResponse;
import de.tekup.rest.services.AskServiceRest;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AskCtrl {
	
	private AskServiceRest service;
	
	@GetMapping("/test/client")
	public String getFormular(Model model) {
		model.addAttribute("request", new CustomerRequest());
		return "ask";
	}
	
	@PostMapping("/test/client")
	public String postFormular(Model model, @ModelAttribute("request") CustomerRequest request) {
		WsResponse response = service.sendRequestToServerFeign(request);
		model.addAttribute("response",response);
		return "reponse";
	}

}
