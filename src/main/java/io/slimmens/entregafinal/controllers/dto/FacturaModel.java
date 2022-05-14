package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
public class FacturaModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("cliente")
    private ClienteModel cliente;

    @JsonProperty("empresa")
    private EmpresaModel empresa;

    @JsonProperty("productos")
    private Set<ProductoFacturadoModel> productos;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("tipo")
    private Tipo tipo;

    @JsonProperty("total")
    private double total;

    enum Tipo {
        A, B, C
    }

}
