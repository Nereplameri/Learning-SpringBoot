package com.alperenavci.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Bütün error 'ler bu class 'ı kullanarak kullanıcıya döndürülecekler.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {
	
	private String id;
	
	private Date errorTime;
	
	private T errors;
}
