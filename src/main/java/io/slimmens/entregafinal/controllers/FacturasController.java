package io.slimmens.entregafinal.controllers;

import io.slimmens.entregafinal.controllers.dto.ClienteModel;
import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.controllers.dto.ProductoFacturadoModel;
import io.slimmens.entregafinal.controllers.mappers.FacturaMapper;
import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.entities.Factura;
import io.slimmens.entregafinal.services.ClientesService;
import io.slimmens.entregafinal.services.EmpresasService;
import io.slimmens.entregafinal.services.FacturaService;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facturas")
public class FacturasController {

	private final FacturaService facturaService;
	private final EmpresasService empresasService;
	private final ClientesService clientesService;
	private final FacturaMapper mapper;

	public FacturasController(FacturaService facturaService, EmpresasService empresasService,
							  ClientesService clientesService, FacturaMapper mapper) {
		this.facturaService = Objects.requireNonNull(facturaService);
		this.empresasService = Objects.requireNonNull(empresasService);
		this.clientesService = Objects.requireNonNull(clientesService);
		this.mapper = Objects.requireNonNull(mapper);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<FacturaModel> get(@PathVariable("id") Integer id) {
		return facturaService.get(id)
				.map(mapper::mapToModel)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<FacturaModel> create(@RequestBody FacturaModel request) {
		Optional<Empresa> empresaOptional = empresasService.get(request.getEmpresa().getId());
		if (empresaOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Empresa empresa = empresaOptional.get();

		ClienteModel clienteModel = request.getCliente();
		Cliente cliente = clientesService.get(clienteModel.getId())
				.orElseGet(() -> clientesService.create(
						clienteModel.getNombre(),
						clienteModel.getApellido(),
						clienteModel.getDireccion(),
						clienteModel.getDni()
				));

		Map<Integer, Integer> cantidadesPorProducto = request.getProductos()
			.stream()
			.collect(Collectors.toMap(
					productoFacturado -> productoFacturado.getProducto().getId(),
					ProductoFacturadoModel::getCantidad
			));

		Factura factura = facturaService.create(cliente, empresa, cantidadesPorProducto);

		return ResponseEntity.ok(mapper.mapToModel(factura));
	}
	
}
