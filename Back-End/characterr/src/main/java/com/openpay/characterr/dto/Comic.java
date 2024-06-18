package com.openpay.characterr.dto;

import java.util.List;
import lombok.Data;

@Data
public class Comic {

	private int available;
	
	private int returned;
	
	private String collectionURI;
	
	private List<Item> items;
	
}
