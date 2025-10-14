package com.alperenavci.services;

import com.alperenavci.dto.DtoAddress;

public interface IAddressService {
	public DtoAddress findAddressById(Long id);
}
