package com.cdac.training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.Model.Address;
import com.cdac.training.Model.Dealer;
import com.cdac.training.service.DealerService;

@RestController
@RequestMapping("/api")
public class DealerController {

	private DealerService dealerService;

	public DealerController(DealerService dealerService) {
		this.dealerService = dealerService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> createDealer(@Validated @RequestBody Dealer dealer) {
		
		Address address=dealer.getAddress();
		
		address.setDealer(dealer);
		dealer.setAddress(address);
		
		Dealer regidteredDealer=dealerService.registeredDealer(dealer);
		return entity;
	}
	
	
	
	
}
