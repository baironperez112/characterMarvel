package com.openpay.characterr.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representation del objeto api response ApiResponse.
 * @author Bayron Perez
 * @param <T>
 * @param <T>
 */

@Getter
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ApiResponse<T> {
	
	private T data;
	
	private Response response;

}