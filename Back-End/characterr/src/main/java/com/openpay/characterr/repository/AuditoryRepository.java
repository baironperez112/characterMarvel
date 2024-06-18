package com.openpay.characterr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openpay.characterr.model.AuditoryEntity;

/**
 * Clase repositorio de implementacion de la especificaicon JPA
 * @author Bayron perez
 */
@Repository
public interface AuditoryRepository extends JpaRepository<AuditoryEntity, Integer> {

}
