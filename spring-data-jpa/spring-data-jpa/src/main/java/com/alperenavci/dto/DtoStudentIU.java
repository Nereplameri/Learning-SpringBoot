package com.alperenavci.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	
	// jakarta.validation.constraints.xxx
	@NotEmpty(message = "Firstname Alanı Boş Bırakılamaz!")
	@Size(min = 3, max = 10)
	private String firstName;
	
	@Size(min = 3, max = 40)
	private String lastName;
	
	private Date birthOfDate;
}
