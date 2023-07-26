package com.departamento.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.service.entity.Departamento;
import com.departamento.service.repositorio.DepartamentoRepository;


@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> getAll(){
		return departamentoRepository.findAll();
	}
	
	public Departamento getDepartamentoById(int id){
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public Departamento save(Departamento departamento) {
		Departamento nuevoDepartamento = departamentoRepository.save(departamento);
		return nuevoDepartamento;
	}	
	
	public List<Departamento> byUsuarioId(int usuarioId){
		return departamentoRepository.findByUsuarioId(usuarioId);	
	}
}
