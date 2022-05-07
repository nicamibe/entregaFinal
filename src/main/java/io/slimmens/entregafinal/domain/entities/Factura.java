package io.slimmens.entregafinal.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

//import javax.persistence.Id;

@Data
@Entity
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "rubro", nullable = false)
	private String rubro;

	public Factura() {
		// Constructor requerido por JPA.
	}

	public Factura(String nombre, String rubro) {
		this.nombre = Objects.requireNonNull(nombre);
		this.rubro = Objects.requireNonNull(rubro);
	}
}
