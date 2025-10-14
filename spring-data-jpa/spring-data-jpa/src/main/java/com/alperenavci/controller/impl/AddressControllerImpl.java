package com.alperenavci.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperenavci.controller.IAdressController;
import com.alperenavci.dto.DtoAddress;
import com.alperenavci.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAdressController{
	
	@Autowired
	IAddressService addressService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
		return addressService.findAddressById(id);
	}
	
}
