package com.openpay.characterr.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.openpay.characterr.client.CharacterrClient;
import com.openpay.characterr.dto.Characterr;
import com.openpay.characterr.repository.AuditoryRepository;
import com.openpay.characterr.service.impl.CharacterrServiceImpl;

class CharacterrServiceImplTest {
	
	@Mock
	CharacterrClient characterrClient;
	
	@Mock
	AuditoryRepository auditoryRepository;
	
	@InjectMocks
	CharacterrServiceImpl characterrServiceImpl;
	
	
	@Test
	void finAllCharacters() {
		when(characterrClient.finAllCharacterrs()).thenReturn(getCharacterList());
		List<Characterr> resp = characterrServiceImpl.finAllCharacterrs();
		assertNotNull(resp);
		assertFalse(false);
	}
	
	@Test
	void findByCharacterId() {
		when(characterrClient.findCharacterrById(anyInt())).thenReturn(getCharacterr());
		Characterr resp = characterrServiceImpl.findCharacterrById(1);
		assertNotNull(resp);
	}
	
	
	private List<Characterr> getCharacterList() {
		List<Characterr> list = new ArrayList<>();
		Characterr character = new Characterr();
		character.setId(1);
		character.setName("prueba");
		character.setDescription("prueba");
		list.add(character);
		return list;
	}
	
	private Characterr getCharacterr() {
		Characterr character = new Characterr();
		character.setId(1);
		character.setName("prueba");
		character.setDescription("prueba");
		return character;
	}
	
}