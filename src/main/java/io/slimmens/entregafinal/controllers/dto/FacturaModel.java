package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.slimmens.entregafinal.domain.entities.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter


public class FacturaModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("cliente")
    private Cliente cliente;

    @JsonProperty("fecha")
    private Date fecha;
}
