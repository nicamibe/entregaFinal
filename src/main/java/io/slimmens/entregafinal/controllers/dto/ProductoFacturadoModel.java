package io.slimmens.entregafinal.controllers.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ProductoFacturadoModel {

  @JsonProperty("producto")
  private ProductoModel producto;

  @JsonProperty("cantidad")
  private int cantidad;

  @JsonProperty("precio")
  private double precio;


}


