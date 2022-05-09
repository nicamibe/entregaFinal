package io.slimmens.entregafinal.controllers.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.slimmens.entregafinal.domain.entities.Factura;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class DetalleFacturaModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nombre_producto")
    private String nombreProducto;

    @JsonProperty("precio_producto")
    private double precioProducto;

    @JsonProperty("factura")
    private Factura factura;
}
