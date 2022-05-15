package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
public class FacturaModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("empresa")
    private EmpresaModel empresa;

    @JsonProperty("total")
    private double total;

    @JsonProperty("cliente")
    private ClienteModel cliente;

    @JsonProperty("productos")
    private Set<ProductoFacturadoModel> productos;


}
