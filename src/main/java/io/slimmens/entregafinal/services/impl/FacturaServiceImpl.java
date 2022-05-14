package io.slimmens.entregafinal.services.impl;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.entities.Factura;
import io.slimmens.entregafinal.domain.entities.Producto;
import io.slimmens.entregafinal.domain.entities.ProductoFacturado;
import io.slimmens.entregafinal.domain.repositories.FacturaRepository;
import io.slimmens.entregafinal.services.ClientesService;
import io.slimmens.entregafinal.services.FacturaService;
import io.slimmens.entregafinal.services.ProductosService;
import io.slimmens.entregafinal.utils.ValidationUtils;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ProductosService productosService;

    @Autowired
    private FacturaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> get(Integer id) {
        ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

        return repository.findById(id);
    }

    @Override
    @Transactional
    public Factura create(Cliente cliente, Empresa empresa, Map<Integer, Integer> cantidadesPorProducto) {
        Set<ProductoFacturado> productos = new HashSet<>();
        for (Integer idProducto : cantidadesPorProducto.keySet()) {
            int cantidad = ValidationUtils.isGreaterThan(
                    cantidadesPorProducto.get(idProducto),
                    0,
                    String.format("La cantidad pedida para el producto con ID '%s' no es valida. Debe ser mayor o igual a 1.", idProducto)
            );

            Producto producto = productosService.updateDisponibilidad(idProducto, -cantidad)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("El producto con ID '%s' no existe.", idProducto)));

            productos.add(new ProductoFacturado(producto, cantidad));
        }

        return repository.save(new Factura(
                cliente,
                empresa,
                productos
        ));
    }
}
