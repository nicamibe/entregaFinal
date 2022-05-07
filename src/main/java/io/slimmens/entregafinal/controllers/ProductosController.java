package io.slimmens.entregafinal.controllers;

import io.slimmens.entregafinal.controllers.mappers.ProductosMapper;
import io.slimmens.entregafinal.controllers.dto.DisponibilidadModel;
import io.slimmens.entregafinal.controllers.dto.ProductoModel;
import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.domain.entities.Producto;
import io.slimmens.entregafinal.services.ProductosService;

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
@RequestMapping("/productos")
public class ProductosController {
	
	private final ProductosService service;
	private final ProductosMapper mapper;
	
	public ProductosController(ProductosService service, ProductosMapper mapper) {
		this.service = Objects.requireNonNull(service);
		this.mapper = Objects.requireNonNull(mapper);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ProductoModel> get(@PathVariable("id") Integer id) {
		return service.get(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CollectionModel<ProductoModel>> list(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
															   @RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Page<Producto> list = service.list(pageNumber, pageSize);
		return ResponseEntity.ok(mapper.mapToModel(list));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel request) {
		Producto cliente = service.create(
				request.getNombre(), 
				request.getDescripcion(),
				request.getPrecio(),
				request.getCantidadDisponible()
		);
		
		return ResponseEntity.ok(mapper.mapToModel(cliente));
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ProductoModel> update(@PathVariable("id") Integer id, @RequestBody ProductoModel request) {
		return service.update(
				id, 
				request.getNombre(), 
				request.getDescripcion(),
				request.getPrecio(),
				request.getCantidadDisponible()
		)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ProductoModel> delete(@PathVariable("id") Integer id) {
		return service.delete(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping(path = "/{id}/disponibilidad", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ProductoModel> updateDisponibilidad(@PathVariable("id") Integer id, @RequestBody DisponibilidadModel request) {
		return service.updateDisponibilidad(id, request.getVariacion())
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
}
