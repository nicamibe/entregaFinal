package io.slimmens.entregafinal.controllers.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.slimmens.entregafinal.domain.entities.Factura;
import io.slimmens.entregafinal.domain.entities.Producto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class DetalleFacturaModel {

  private Producto producto;

    public DetalleFacturaModel (){

    }

    public DetalleFacturaModel(Producto producto) {
        this.producto = producto;
    }
}
