package io.slimmens.entregafinal.services;

import io.slimmens.entregafinal.domain.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProductosService {
    @Transactional(readOnly = true)
    Optional<Producto> get(Integer id);

    @Transactional(readOnly = true)
    Page<Producto> list(Integer pageNumber, Integer pageSize);

    @Transactional
    Producto create(String nombre, String descripcion, Double precio, Integer cantidadDisponible);

    @Transactional
    Optional<Producto> update(Integer id, String nombre, String descripcion,
                              Double precio, Integer cantidadDisponible);

    @Transactional
    Optional<Producto> delete(Integer id);

    @Transactional
    Optional<Producto> updateDisponibilidad(Integer id, Integer variacion);

    Producto getProductoByNombre(String nombre);
}
