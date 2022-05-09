package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.Factura;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FacturaRepository extends PagingAndSortingRepository<Factura, Integer> {
}
