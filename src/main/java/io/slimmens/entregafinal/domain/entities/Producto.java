package io.slimmens.entregafinal.domain.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "nro_producto")
	private int nroProducto;

	@Column(name = "precio", nullable = false)
	private double precio;

	@Column(name = "cantidad_disponible", nullable = false)
	private int cantidadDisponible;

	public Producto() {
		// Constructor requerido por JPA.
	}

	public Producto(String nombre, String descripcion, Double precio, Integer cantidadDisponible) {
		this.nombre = Objects.requireNonNull(nombre);
		this.descripcion = Objects.requireNonNull(descripcion);
		this.precio = Objects.requireNonNull(precio);
		this.cantidadDisponible = Objects.requireNonNull(cantidadDisponible);
	}

}
