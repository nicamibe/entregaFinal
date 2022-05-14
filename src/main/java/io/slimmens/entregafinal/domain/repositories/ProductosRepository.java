package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductosRepository extends PagingAndSortingRepository<Producto, Integer> {


}
