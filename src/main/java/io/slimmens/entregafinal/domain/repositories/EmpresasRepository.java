package io.slimmens.entregafinal.domain.repositories;

import io.slimmens.entregafinal.domain.entities.Empresa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmpresasRepository extends PagingAndSortingRepository<Empresa, Integer> {

}
