package io.slimmens.entregafinal.controllers.mappers;

import io.slimmens.entregafinal.controllers.dto.ClienteModel;
import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.domain.entities.Cliente;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClientesMapper {

	public ClienteModel mapToModel(Cliente domain) {
		ClienteModel model = new ClienteModel();
		model.setId(domain.getId());
		model.setNombre(domain.getNombre());
		model.setApellido(domain.getApellido());
		model.setDni(domain.getDni());
		model.setDireccion(domain.getDireccion());

		return model;
	}

	public CollectionModel<ClienteModel> mapToModel(Page<Cliente> domain) {
		CollectionModel<ClienteModel> model = new CollectionModel<>();
		model.setTotal(domain.getTotalElements());

		model.setItems(domain.stream()
				.map(this::mapToModel)
				.collect(Collectors.toList())
		);

		return model;
	}

}
