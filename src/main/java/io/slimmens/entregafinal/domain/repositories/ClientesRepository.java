package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientesRepository extends PagingAndSortingRepository<Cliente, Integer> {

}
