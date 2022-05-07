package io.slimmens.entregafinal.controllers.mappers;

import io.slimmens.entregafinal.controllers.dto.ProductoModel;
import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.domain.entities.Producto;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductosMapper {
	
	public ProductoModel mapToModel(Producto domain) {
		ProductoModel model = new ProductoModel();
		model.setId(domain.getId());
		model.setNombre(domain.getNombre());
		model.setDescripcion(domain.getDescripcion());
		model.setPrecio(domain.getPrecio());
		model.setCantidadDisponible(domain.getCantidadDisponible());
		
		return model;
	}

	public CollectionModel<ProductoModel> mapToModel(Page<Producto> domain) {
		CollectionModel<ProductoModel> model = new CollectionModel<>();
		model.setTotal(domain.getTotalElements());
		
		model.setItems(domain.stream()
				.map(this::mapToModel)
				.collect(Collectors.toList())
		);

		return model;
	}
	
}
