package io.slimmens.entregafinal.services.impl;
import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.entities.Factura;
import io.slimmens.entregafinal.domain.entities.Producto;
import io.slimmens.entregafinal.services.ClientesService;
import io.slimmens.entregafinal.services.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@Slf4j
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private ClientesService clientesService;

    @Override
    public Factura crearFactura(Cliente cliente, Empresa empresa, Map<Integer, Integer> cantidadesPorProducto) {
        Cliente clienteDB = clientesService.crearSiNoExiste(cliente);

        return null;
    }
}
