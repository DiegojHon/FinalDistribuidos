package com.usuario.service.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.feignclients.CarroFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.repositorio.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CarroFeignClient carroFeignClient;
	
	
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(int id){
		return usuarioRepository.findById(id).orElse(null);
	}
	
	
	public Carro saveCarro(int usuarioId,Carro carro) {
		carro.setUsuarioId(usuarioId);
		Carro nuevoCarro = carroFeignClient.save(carro);
		return nuevoCarro;
	}
	public Usuario save(Usuario usuario) {
		
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		return nuevoUsuario;
	}	
	
  
	public Map<String, Object> getUsuarioAndVehiculos(int usuarioId){
		Map<String,Object> resultado = new HashMap<>();
		Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
		
		if(usuario == null) {
			resultado.put("mensaje", "Usuario Inexistente");
			return resultado;
		}
		resultado.put("Usuario", usuario);
		List<Carro> carros= carroFeignClient.getCarros(usuarioId);
		if(carros.isEmpty()) {
			resultado.put("Carros", "No cuenta con carro");
		}else {
			resultado.put("Carros", carros);
       }
		return resultado;
	}
}
