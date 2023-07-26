package com.casa.service.servicio;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa.service.entity.Casa;
import com.casa.service.repositorio.CasaRepository;



@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;
	
	public List<Casa> getAll(){
		return casaRepository.findAll();
	}
	public Casa getCasaById(int id){
		return casaRepository.findById(id).orElse(null);
	}
	
	public Casa save(Casa casa) {
		Casa nuevaCasa = casaRepository.save(casa);
		return nuevaCasa;
	}	
	
	public List<Casa> byUsuarioId(int usuarioId){
		return casaRepository.findByUsuarioId(usuarioId);	
	}
}
