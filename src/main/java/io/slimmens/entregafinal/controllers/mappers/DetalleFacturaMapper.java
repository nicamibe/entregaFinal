package io.slimmens.entregafinal.controllers.mappers;


import io.slimmens.entregafinal.controllers.dto.CollectionModel;
import io.slimmens.entregafinal.controllers.dto.DetalleFacturaModel;
import io.slimmens.entregafinal.controllers.dto.EmpresaModel;
import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.domain.entities.DetalleFactura;
import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.entities.Factura;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;


@Component
public class DetalleFacturaMapper {

    public DetalleFacturaModel mapToModel(DetalleFactura domain) {
        DetalleFacturaModel model = new DetalleFacturaModel();
        model.setId(domain.getId());
        model.setNombreProducto(domain.getNombreProducto());
        model.setPrecioProducto(domain.getPrecioProducto());
        model.setFactura(domain.getFactura());


        return model;
    }

    public CollectionModel<DetalleFacturaModel> mapToModel(Page<DetalleFactura> domain) {
        CollectionModel<DetalleFacturaModel> model = new CollectionModel<>();
        model.setTotal(domain.getTotalElements());

        model.setItems(domain.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList())
        );

        return model;
    }
}
