package io.slimmens.entregafinal.services;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.entities.Factura;

import java.util.Map;
import java.util.Optional;

public interface FacturaService {

    Optional<Factura> get(Integer id);

    Factura create(Cliente client, Empresa empresa, Map<Integer, Integer> cantidadesPorProducto);
}
