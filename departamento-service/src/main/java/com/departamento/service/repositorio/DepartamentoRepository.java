package com.departamento.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.departamento.service.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	List<Departamento> findByUsuarioId(int usuarioId);
	
}
