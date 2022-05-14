package io.slimmens.entregafinal.controllers.mappers;

import io.slimmens.entregafinal.controllers.dto.ProductoFacturadoModel;
import io.slimmens.entregafinal.domain.entities.ProductoFacturado;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ProductoFacturadosMapper {

	private final ProductosMapper productosMapper;

	public ProductoFacturadosMapper(ProductosMapper productosMapper) {
		this.productosMapper = productosMapper;
	}

	public ProductoFacturadoModel mapToModel(ProductoFacturado domain) {
		ProductoFacturadoModel model = new ProductoFacturadoModel();
		model.setProducto(productosMapper.mapToModel(domain.getProducto()));
		model.setCantidad(domain.getCantidad());
		model.setPrecio(domain.getPrecio());

		return model;
	}

	public Set<ProductoFacturadoModel> mapToModel(Set<ProductoFacturado> domain) {
		return domain.stream()
				.map(this::mapToModel)
				.collect(Collectors.toSet());
	}

}
