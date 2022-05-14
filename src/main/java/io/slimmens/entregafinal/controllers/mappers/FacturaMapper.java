package io.slimmens.entregafinal.controllers.mappers;

import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.domain.entities.Factura;
import org.springframework.stereotype.Component;

@Component
public class FacturaMapper {

    private final EmpresasMapper empresasMapper;
    private final ClientesMapper clientesMapper;
    private final ProductoFacturadosMapper productoFacturadosMapper;

    public FacturaMapper(EmpresasMapper empresasMapper, ClientesMapper clientesMapper,
                         ProductoFacturadosMapper productoFacturadosMapper) {
        this.empresasMapper = empresasMapper;
        this.clientesMapper = clientesMapper;
        this.productoFacturadosMapper = productoFacturadosMapper;
    }

    public FacturaModel mapToModel(Factura domain) {
        FacturaModel model = new FacturaModel();

        model.setCliente(clientesMapper.mapToModel(domain.getCliente()));
        model.setEmpresa(empresasMapper.mapToModel(domain.getEmpresa()));
        model.setProductos(productoFacturadosMapper.mapToModel(domain.getProductos()));
        model.setFecha(domain.getFecha());

        return model;
    }

}
