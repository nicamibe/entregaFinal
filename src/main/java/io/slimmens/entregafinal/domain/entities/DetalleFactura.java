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

    @Column(name = "precio_producto")
    private double precioProducto;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonBackReference
    private Factura factura;


    public DetalleFactura(int id, String nombreProducto, double precioProducto, Factura factura) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.factura = factura;
    }

    public DetalleFactura() {
        // Constructor requerido por JPA.
    }

}
