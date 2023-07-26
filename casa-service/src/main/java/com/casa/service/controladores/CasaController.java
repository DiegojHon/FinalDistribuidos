package com.casa.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa.service.entity.Casa;
import com.casa.service.servicio.CasaService;


@RestController
@RequestMapping("/casa")
public class CasaController {

	@Autowired
	private CasaService casaService;
	
	@GetMapping
	public ResponseEntity<List<Casa>> listarCasas() {
		List<Casa> casas = casaService.getAll();
		if (casas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(casas);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Casa> obtenerCasa(@PathVariable("id") int id) {
		Casa casa = casaService.getCasaById(id);
		if (casa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(casa);
	}

	@PostMapping
	public ResponseEntity<Casa> guardarCasa(@RequestBody Casa casa) {
		Casa nuevaCasa = casaService.save(casa);
		return ResponseEntity.ok(nuevaCasa);

	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Casa>> listarCasaPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Casa> casas=casaService.byUsuarioId(id);
		if (casas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(casas);
	}
}
