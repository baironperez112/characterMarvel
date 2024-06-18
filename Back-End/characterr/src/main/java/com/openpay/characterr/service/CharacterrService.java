package com.openpay.characterr.service;

import java.util.*;

import com.openpay.characterr.dto.Characterr;
import com.openpay.characterr.model.AuditoryEntity;

/**
 * Metodos encargados se realiar los servicios de Marvel 
 * @author Bayron Andres Perez
 */
public interface CharacterrService {

	public List<Characterr> finAllCharacterrs();

	public Characterr findCharacterrById(Integer characterr);
	
	public List<AuditoryEntity> findAuditory();
}
