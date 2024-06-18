package com.openpay.characterr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openpay.characterr.client.CharacterrClient;
import com.openpay.characterr.dto.ApiResponseCode;
import com.openpay.characterr.dto.Characterr;
import com.openpay.characterr.exception.AplicationException;
import com.openpay.characterr.exception.NotFoundException;
import com.openpay.characterr.model.AuditoryEntity;
import com.openpay.characterr.repository.AuditoryRepository;
import com.openpay.characterr.service.CharacterrService;

/**
 * Clase de implementacion de los servicios de characterr
 * @author Bayron Perez
 */

@Service
public class CharacterrServiceImpl implements CharacterrService {

	@Autowired
	private CharacterrClient characterrClient;

	@Autowired
	AuditoryRepository auditoryRepository;

	/**
	 * Metodo encargado de obtener la lista de charaters
	 * @param characterr: id del Character
	 * @author Bayron Perez
	 */
	@Override
	public List<Characterr> finAllCharacterrs() {
		try {
			List<Characterr> respons = characterrClient.finAllCharacterrs();

			//Se registra vitacora en H2
			AuditoryEntity object = new AuditoryEntity();
			object.setDate(new Date());
			auditoryRepository.save(object);

			return respons;
		} catch (Exception e) {
			throw new AplicationException(ApiResponseCode.GENERIC_ERROR.getCode(),
					ApiResponseCode.GENERIC_ERROR.getDescription(),
					ApiResponseCode.GENERIC_ERROR.getHttpStatus());
		}
	}

	/**
	 * Metodo encargado de obtener el charater por el identificador
	 * @param characterr: id del Character
	 * @author Bayron Perez
	 */
	@Override
	public Characterr findCharacterrById(Integer characterr) {
		try {
			Characterr response = characterrClient.findCharacterrById(characterr);
			//Se registra vitacora en H2
			AuditoryEntity object = new AuditoryEntity();
			object.setDate(new Date());
			auditoryRepository.save(object);

			if(response == null) {
				throw new NotFoundException("Codigo characterr", String.valueOf(characterr));
			}
			return response;
		} catch (Exception e) {
			throw new AplicationException(ApiResponseCode.GENERIC_ERROR.getCode(),
					ApiResponseCode.GENERIC_ERROR.getDescription(),
					ApiResponseCode.GENERIC_ERROR.getHttpStatus());
		}
	}

	
	/**
	 * Metodo encargado de obtener el registro de auditorias de peticiones
	 * @author Bayron Perez
	 */
	@Override
	public List<AuditoryEntity> findAuditory() {
		try {
			return auditoryRepository.findAll();
			
		} catch (Exception e) {
			throw new AplicationException(ApiResponseCode.GENERIC_ERROR.getCode(),
					ApiResponseCode.GENERIC_ERROR.getDescription(),
					ApiResponseCode.GENERIC_ERROR.getHttpStatus());
		}
	}

}
