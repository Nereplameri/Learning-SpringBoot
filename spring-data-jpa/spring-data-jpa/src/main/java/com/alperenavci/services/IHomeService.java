package com.alperenavci.services;

import com.alperenavci.dto.DtoHome;

public interface IHomeService {
	public DtoHome findHomeById(Long id);
}
