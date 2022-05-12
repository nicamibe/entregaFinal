package io.slimmens.entregafinal.controllers.dto;


import io.slimmens.entregafinal.domain.entities.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter


public class FacturaModel {


    private Date fecha;

    private Cliente cliente;

    private List<DetalleFacturaModel> detalleFacturaModel;

    public FacturaModel() {

    }

    public FacturaModel(Date fecha, Cliente cliente, DetalleFacturaModel detalleFacturaMod, List<DetalleFacturaModel> detalleFacturaModel) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalleFacturaModel = detalleFacturaModel;
    }
}
