package io.slimmens.entregafinal.controllers;

import io.slimmens.entregafinal.controllers.mappers.EmpresasMapper;
import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.controllers.dto.EmpresaModel;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.services.EmpresasService;

import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	private final EmpresasService service;
	private final EmpresasMapper mapper;

	public EmpresasController(EmpresasService service, EmpresasMapper mapper) {
		this.service = Objects.requireNonNull(service);
		this.mapper = Objects.requireNonNull(mapper);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<EmpresaModel> get(@PathVariable("id") Integer id) {
		return service.get(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CollectionModel<EmpresaModel>> list(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
															  @RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Page<Empresa> list = service.list(pageNumber, pageSize);
		return ResponseEntity.ok(mapper.mapToModel(list));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<EmpresaModel> create(@RequestBody EmpresaModel request) {
		Empresa empresa = service.create(request.getNombre(), request.getRubro());
		return ResponseEntity.ok(mapper.mapToModel(empresa));
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<EmpresaModel> update(@PathVariable("id") Integer id, @RequestBody EmpresaModel request) {
		return service.update(id, request.getNombre(), request.getRubro())
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<EmpresaModel> delete(@PathVariable("id") Integer id) {
		return service.delete(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
