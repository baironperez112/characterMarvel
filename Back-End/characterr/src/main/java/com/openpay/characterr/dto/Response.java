package com.openpay.characterr.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Response implements Serializable{

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String description;

	private String source;
	
}
