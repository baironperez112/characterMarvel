package com.openpay.characterr.dto;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ApiResponseCode {

	/**
	 * Codigo de respuesta exitoso
	 */
	SUCCESS("S000", "Success", HttpStatus.OK),

	/**
	 * Codigo generico de error
	 */
	GENERIC_ERROR("E001", "Ocurrió un error interno, intente de nuevo más tarde", HttpStatus.BAD_REQUEST),

	/**
	 * Error cuando no existe el valor de un parametro
	 */
	ERROR_PARAMETRO_NOT_FOUND("E002", "No se encontró el valor del parámetro consultado.  ", HttpStatus.NOT_FOUND),

	/**
	 * Error cuando no existen datos en la respuesta
	 */
	GENERIC_DATOS_NOT_FOUND("E003", "No se encontró el registro consultado.  ", HttpStatus.NOT_FOUND);
	
	private String code;

	private String description;

	private HttpStatus httpStatus;

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}