package io.slimmens.entregafinal.services;

import io.slimmens.entregafinal.domain.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EmpresasService {
    @Transactional(readOnly = true)
    Optional<Empresa> get(Integer id);

    @Transactional(readOnly = true)
    Page<Empresa> list(Integer pageNumber, Integer pageSize);

    @Transactional
    Empresa create(String nombre, String rubro);

    @Transactional
    Optional<Empresa> update(Integer id, String nombre, String rubro);

    @Transactional
    Optional<Empresa> delete(Integer id);
}
