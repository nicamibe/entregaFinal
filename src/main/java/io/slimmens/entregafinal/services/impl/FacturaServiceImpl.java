package io.slimmens.entregafinal.services.impl;
import java.util.Date;
import io.slimmens.entregafinal.controllers.dto.DetalleFacturaModel;
import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.DetalleFactura;
import io.slimmens.entregafinal.domain.entities.Factura;
import io.slimmens.entregafinal.domain.entities.Producto;
import io.slimmens.entregafinal.domain.repositories.FacturaRepository;
import io.slimmens.entregafinal.services.ClientesService;
import io.slimmens.entregafinal.services.ProductosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Slf4j
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ProductosService productosService;

    @Autowired
    ClientesService clientesService;

    public Factura facturarProducto(FacturaModel facturaModel){
        Cliente cliente = clientesService.obtenerClientePorId(facturaModel.getCliente());
        List<Producto> productoList = new ArrayList<>();
        for (DetalleFacturaModel detalleFacturaModel : facturaModel.getDetalleFacturaModel()) {
            Producto producto = productosService.getProductoByNombre(detalleFacturaModel.getProducto().getNombre());
            productoList.add(producto);

        }
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setFecha(facturaModel.getFecha());
        factura.setDetalleFactura(new HashSet<>());
        for (DetalleFacturaModel detalleFacturaModel : facturaModel.getDetalleFacturaModel()) {
            factura.agregarDetalle(crearDetalleFactura(detalleFacturaModel))
        }
        Factura factura1 = facturaRepository.save(factura);
        log.error("cuidado con la factura {}",factura1);
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>productosService.restarStock(productoList);
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        DetalleFactura crearDetalleFactura(DetalleFacturaModel detalleFactura){
        }
    }

}
