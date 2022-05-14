package io.slimmens.entregafinal.services;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.entities.Factura;

import java.util.Map;

public interface FacturaService {

    Factura crearFactura(Cliente client, Empresa empresa, Map<Integer, Integer> cantidadesPorProducto);
}
