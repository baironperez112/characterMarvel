package com.openpay.characterr.dto;

import java.util.*;
import lombok.Data;

@Data
public class Serie {

	private int available;
	
	private int returned;
	
	private String collectionURI;
	
	private List<Item> items;
}
