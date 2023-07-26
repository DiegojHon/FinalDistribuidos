package com.casa.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa.service.entity.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Integer>{ 

		List<Casa> findByUsuarioId(int usuarioId);
	}

