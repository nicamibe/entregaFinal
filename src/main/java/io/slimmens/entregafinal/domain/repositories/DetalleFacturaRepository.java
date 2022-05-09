package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.DetalleFactura;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DetalleFacturaRepository extends PagingAndSortingRepository<DetalleFactura, Integer> {
}
