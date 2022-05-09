package io.slimmens.entregafinal.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalle_factura")
@Setter
@Getter

public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    //---------------VER EL TEMA DEL PRECIO-------------

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonBackReference
    private Factura factura;







    public DetalleFactura() {
        // Constructor requerido por JPA.
    }

}
