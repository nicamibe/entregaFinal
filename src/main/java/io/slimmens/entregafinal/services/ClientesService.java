package io.slimmens.entregafinal.services;

import io.slimmens.entregafinal.domain.entities.Cliente;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface ClientesService {

    Optional<Cliente> get(Integer id);

    Page<Cliente> list(Integer pageNumber, Integer pageSize);

    Cliente create(String nombre, String apellido, String direccion, Integer dni);

    Optional<Cliente> update(Integer id, String nombre, String apellido, String direccion, Integer dni);

    Optional<Cliente> delete(Integer id);

}

