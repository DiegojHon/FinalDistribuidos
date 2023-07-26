package com.departamento.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.service.entity.Departamento;
import com.departamento.service.servicio.DepartamentoService;


@RestController
@RequestMapping("/departamento")

public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	public ResponseEntity<List<Departamento>> listarDepartamentos() {
		List<Departamento> departamentos = departamentoService.getAll();
		if (departamentos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(departamentos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> obtenerDepartamento(@PathVariable("id") int id) {
		Departamento departamento = departamentoService.getDepartamentoById(id);
		if (departamento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(departamento);
	}

	@PostMapping
	public ResponseEntity<Departamento> guardarDepartamento(@RequestBody Departamento departamento) {
		Departamento nuevoDepartamento = departamentoService.save(departamento);
		return ResponseEntity.ok(nuevoDepartamento);

	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Departamento>> listarDepartamentosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Departamento> departamentos=departamentoService.byUsuarioId(id);
		if (departamentos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(departamentos);
	}
}

