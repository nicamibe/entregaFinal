package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Factura;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FacturaRepository extends PagingAndSortingRepository<Factura, Integer> {

    List<Factura> findAllByCliente(Cliente cliente);
}
