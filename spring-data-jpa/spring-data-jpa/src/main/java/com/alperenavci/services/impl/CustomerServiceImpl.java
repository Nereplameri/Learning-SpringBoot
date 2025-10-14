package com.alperenavci.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenavci.dto.DtoAddress;
import com.alperenavci.dto.DtoCustomer;
import com.alperenavci.entites.Address;
import com.alperenavci.entites.Customer;
import com.alperenavci.repository.CustomerRepository;
import com.alperenavci.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		if (optional.isEmpty()) {
			return null;
		}
		
		Customer customer = optional.get();
		Address address= customer.getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		
		dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;
	}
	
	
}
