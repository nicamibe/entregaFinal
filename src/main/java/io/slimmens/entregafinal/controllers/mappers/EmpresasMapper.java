package io.slimmens.entregafinal.controllers.mappers;

import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.controllers.dto.EmpresaModel;
import io.slimmens.entregafinal.domain.entities.Empresa;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class EmpresasMapper {

	public EmpresaModel mapToModel(Empresa domain) {
		EmpresaModel model = new EmpresaModel();
		model.setId(domain.getId());
		model.setNombre(domain.getNombre());
		model.setRubro(domain.getRubro());

		return model;
	}

	public CollectionModel<EmpresaModel> mapToModel(Page<Empresa> domain) {
		CollectionModel<EmpresaModel> model = new CollectionModel<>();
		model.setTotal(domain.getTotalElements());

		model.setItems(domain.stream()
				.map(this::mapToModel)
				.collect(Collectors.toList())
		);

		return model;
	}

}
