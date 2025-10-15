package com.alperenavci.controller;

import com.alperenavci.dto.DtoHome;

public interface IHomeController {
	public DtoHome findHomeById(Long id);
}
