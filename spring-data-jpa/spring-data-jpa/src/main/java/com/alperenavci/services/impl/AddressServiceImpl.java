package com.alperenavci.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenavci.dto.DtoAddress;
import com.alperenavci.dto.DtoCustomer;
import com.alperenavci.entites.Address;
import com.alperenavci.entites.Customer;
import com.alperenavci.repository.AddressRepository;
import com.alperenavci.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	public DtoAddress findAddressById(Long id) {
		DtoAddress dtoAddress = new DtoAddress();
		DtoCustomer dtoCustomer = new DtoCustomer();
		
		Optional<Address> optional = addressRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		
		Address address = optional.get();
		Customer customer = address.getCustomer();
		
		BeanUtils.copyProperties(address, dtoAddress);
		BeanUtils.copyProperties(customer, dtoCustomer);
		
		dtoAddress.setCustomer(dtoCustomer);
		
		return dtoAddress;
	}
	
}
