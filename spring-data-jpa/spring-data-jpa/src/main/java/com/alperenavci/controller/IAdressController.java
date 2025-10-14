package com.alperenavci.controller;

import com.alperenavci.dto.DtoAddress;

public interface IAdressController {
	public DtoAddress findAddressById(Long id);
}
