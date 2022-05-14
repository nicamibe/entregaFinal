package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.ProductoFacturado;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DetalleFacturaRepository extends PagingAndSortingRepository<ProductoFacturado, Integer> {
}
