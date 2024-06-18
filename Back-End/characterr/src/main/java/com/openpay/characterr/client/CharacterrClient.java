package com.openpay.characterr.client;

import com.openpay.characterr.dto.Characterr;
import com.openpay.characterr.utils.Constants;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterrClient {


	private static final RestTemplate restTemplate = new RestTemplate();


	public List<Characterr> finAllCharacterrs() {
		String interactionURL = Constants.END_POINT + Constants.VERSION + Constants.CHARACTER + 
				"?ts=" + Constants.TS + "&apikey=" + Constants.APYKEY + "&hash=" + Constants.HASH;
		ResponseEntity<List<Characterr>> responseEntity = null;
		try {
			HttpEntity<Characterr> entity = new HttpEntity<>(getHeaders());
			ParameterizedTypeReference<List<Characterr>> typeRef = new ParameterizedTypeReference<>() {};
			responseEntity = restTemplate.exchange(
					interactionURL, HttpMethod.GET, entity, typeRef);

			if ( responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
				return responseEntity.getBody();
			}
		} catch (Exception ex) {
		}
		return null;
	}

	public Characterr findCharacterrById(Integer characterr) {
		String interactionURL = Constants.END_POINT + Constants.VERSION + Constants.CHARACTER + "/" + characterr +
				"?ts=" + Constants.TS + "&apikey=" + Constants.APYKEY + "&hash=" + Constants.HASH;
		ResponseEntity<Characterr> responseEntity = null;
		try {
			HttpEntity<Characterr> entity = new HttpEntity<>(getHeaders());
			responseEntity = restTemplate.exchange(
					interactionURL, HttpMethod.GET, entity, Characterr.class, characterr);

			if ( responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
				return responseEntity.getBody();
			}
		} catch (Exception ex) {
		}
		return null;
	}


	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
