package com.openpay.characterr.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.openpay.characterr.dto.ApiResponse;
import com.openpay.characterr.dto.Characterr;
import com.openpay.characterr.service.impl.CharacterrServiceImpl;

@ExtendWith(MockitoExtension.class)
class CharactersControllerTest {

	@Mock
	CharacterrServiceImpl characterrServiceImpl;
	
	@InjectMocks
	CharactersController charactersController;
	
	
	@Test
	void finAllCharacters() {
		when(characterrServiceImpl.finAllCharacterrs()).thenReturn(getCharacterList());
		ResponseEntity<ApiResponse<List<Characterr>>> resp = charactersController.getCharacters();
		assertNotNull(resp);
		assertFalse(false);
	}
	
	@Test
	void findByCharacterId() {
		when(characterrServiceImpl.findCharacterrById(anyInt())).thenReturn(getCharacterr());
		ResponseEntity<ApiResponse<Characterr>> resp = charactersController.getCharactersById(1);
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
