package io.slimmens.entregafinal.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productos_facturados")
@Setter
@Getter

public class ProductoFacturado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private double precio;

    public ProductoFacturado(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = producto.getPrecio();
    }

    public ProductoFacturado() {
        // Constructor requerido por JPA.
    }

}
