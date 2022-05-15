package io.slimmens.entregafinal.controllers.mappers;

import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.controllers.dto.ProductoFacturadoModel;
import io.slimmens.entregafinal.domain.entities.Factura;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        model.setId(domain.getId());
        model.setTipo(domain.getTipo());

        double total = 0;
        for (ProductoFacturadoModel producto : model.getProductos()) {
            total += producto.getTotalParcial();
        }
        model.setTotal(total);

        return model;
    }

    public CollectionModel<FacturaModel> mapToModel(List<Factura> domain) {
        CollectionModel<FacturaModel> model = new CollectionModel<>();
        model.setTotal(domain.size());

        model.setItems(domain.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList())
        );

        return model;
    }

}
