package com.alperenavci.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private List<String> addMapValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}
	
	// anatasyondaki value ile fonksiyonun parametresi aynı olmak zorunda
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError<Map<String,List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		// "listName : Hata1, hata2, hata3" şeklinde tutmak için oluşturulan Map.
		// "validation : error1, error2 ..."
		Map<String, List<String>> errorMap = new HashMap<>();
		
		// "ex.getBindingResult().getAllErrors()": Validasyon sonrası bütün hata mesajlarını getirir.
		for (ObjectError objError: ex.getBindingResult().getAllErrors()) {
			
			// Hangi filed 'den hata geliyor, onu tutar. (lastName mi?, firstName mi?)
			String fieldName = ((FieldError)objError).getField();
			
			if(errorMap.containsKey(fieldName)) { // field, map 'ta bulunuyorsa yapılacaklar
				
				// "errormap.value" Önceki error çıktılarının yanına yeni hatayı ekleyip "errorMap" 'e atayacak
				// ".getDefaultMessage": Hata mesajını getirir.
				errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), objError.getDefaultMessage()));
				
			}
			else { // field, map 'ta bulunmuyorsa yapılacaklar.
				errorMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorMap));
	}
	
	
	private <T> ApiError<T> createApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		
		return apiError;
	}
}
