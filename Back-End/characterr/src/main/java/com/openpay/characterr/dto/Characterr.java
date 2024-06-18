package com.openpay.characterr.dto;

import java.util.*;
import lombok.Data;

@Data
public class Characterr {

	private int id;
	
	private String name;
	
	private String description;
	
	private Date modified;
	
	private String resourceURI;
	
	private List<Urls> urls;
	
	private Thumbnail thumbnail;
	
	private Comic comics;
	
	private Storie stories;
	
	private Event events;
	
	private Serie series;
}
