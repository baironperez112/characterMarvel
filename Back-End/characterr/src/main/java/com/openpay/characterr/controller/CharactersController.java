package com.openpay.characterr.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpay.characterr.dto.ApiResponse;
import com.openpay.characterr.dto.ApiResponseCode;
import com.openpay.characterr.dto.Characterr;
import com.openpay.characterr.dto.Response;
import com.openpay.characterr.model.AuditoryEntity;
import com.openpay.characterr.service.impl.CharacterrServiceImpl;
import com.openpay.characterr.utils.Constants;

/**
 * Controlador responsable de exponer los metodos de Marvel characterr
 * @author Bayron Perez Perez Muñoz
 */

@RestController
@RequestMapping(Constants.VERSION + Constants.CHARACTER)
public class CharactersController {

	@Autowired
	CharacterrServiceImpl characterrServiceImpl;
	
	
	/**
	 * Servicio encargado de retornar la consulta de todos los characters
	 * @return ResponseEntity<ApiResponseADE<List<Character>>>
	 * @author Bayron Perez Muñoz
	 */
	@GetMapping(value = Constants.fIN_ALL)
	public ResponseEntity<ApiResponse<List<Characterr>>> getCharacters() {
		List<Characterr> consulta = characterrServiceImpl.finAllCharacterrs();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>(consulta, Response.builder().code(ApiResponseCode.SUCCESS.getCode())
						.description(ApiResponseCode.SUCCESS.getDescription()).build()));
	}
	
	
	/**
	 * Servicio encargado de retornar el character segun su ID
	 * 
	 * @return ResponseEntity<ApiResponseADE<Character>>
	 * @author Bayron Andres Perez Muñoz
	 */
	@GetMapping(value = Constants.FIND_BY_SHARED_KEY + "/{characterId}")
	public ResponseEntity<ApiResponse<Characterr>> getCharactersById(@PathVariable(name = "characterId") Integer characterId) {
		Characterr consulta = characterrServiceImpl.findCharacterrById(characterId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>(consulta, Response.builder().code(ApiResponseCode.SUCCESS.getCode())
						.description(ApiResponseCode.SUCCESS.getDescription()).build()));
	}
	
	
	/**
	 * Servicio encargado de retornar la vitacora de peticiones
	 * @return ResponseEntity<ApiResponseADE<AuditoryEntity>>
	 * @author Bayron Perez
	 */
	@GetMapping(value = Constants.FIND_AUDITORY )
	public ResponseEntity<ApiResponse<List<AuditoryEntity>>> getAuditory() {
		List<AuditoryEntity> consulta = characterrServiceImpl.findAuditory();
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>(consulta, Response.builder().code(ApiResponseCode.SUCCESS.getCode())
						.description(ApiResponseCode.SUCCESS.getDescription()).build()));
	}
	
}