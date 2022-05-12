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

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacturaMapper {

    public FacturaModel mapToModel(Factura domain) {
        FacturaModel model = new FacturaModel();

        model.setCliente(domain.getCliente());
        model.setFecha(domain.getFecha());

        return model;
    }

    public CollectionModel<FacturaModel> mapToModel(Page<Factura> domain) {
        CollectionModel<FacturaModel> model = new CollectionModel<>();
        model.setTotal(domain.getTotalElements());

        model.setItems(domain.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList())
        );

        return model;
    }
}
