package com.alperenavci.services;

import com.alperenavci.dto.DtoCustomer;

public interface ICustomerService {
	public DtoCustomer findCustomerById(Long id);
}
