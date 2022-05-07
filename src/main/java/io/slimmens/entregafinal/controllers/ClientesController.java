package io.slimmens.entregafinal.controllers;

import io.slimmens.entregafinal.controllers.mappers.ClientesMapper;
import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.controllers.dto.ClienteModel;
import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.services.impl.ClientesServiceImpl;
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
@RequestMapping("/clientes")
public class ClientesController {
	
	private final ClientesServiceImpl service;
	private final ClientesMapper mapper;
	
	public ClientesController(ClientesServiceImpl service, ClientesMapper mapper) {
		this.service = Objects.requireNonNull(service);
		this.mapper = Objects.requireNonNull(mapper);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ClienteModel> get(@PathVariable("id") Integer id) {
		return service.get(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CollectionModel<ClienteModel>> list(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
															  @RequestParam(value = "pageSize", required = false) Integer pageSize) {
		Page<Cliente> list = service.list(pageNumber, pageSize);
		return ResponseEntity.ok(mapper.mapToModel(list));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel request) {
		Cliente cliente = service.create(
				request.getNombre(),
				request.getApellido(),
				request.getDireccion(),
				request.getDni()
		);

		return ResponseEntity.ok(mapper.mapToModel(cliente));
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ClienteModel> update(@PathVariable("id") Integer id, @RequestBody ClienteModel request) {
		return service.update(
				id,
				request.getNombre(),
				request.getApellido(),
				request.getDireccion(),
				request.getDni()
		)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ClienteModel> delete(@PathVariable("id") Integer id) {
		return service.delete(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
}
