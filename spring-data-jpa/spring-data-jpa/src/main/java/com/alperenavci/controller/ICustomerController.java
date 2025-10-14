package com.alperenavci.controller;

import com.alperenavci.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerById(Long id);
}
