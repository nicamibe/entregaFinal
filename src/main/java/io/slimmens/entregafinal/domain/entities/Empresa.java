package io.slimmens.entregafinal.domain.entities;

import java.util.Objects;
import javax.persistence.*;
//import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "rubro", nullable = false)
	private String rubro;

	public Empresa() {
		// Constructor requerido por JPA.
	}

	public Empresa(String nombre, String rubro) {
		this.nombre = Objects.requireNonNull(nombre);
		this.rubro = Objects.requireNonNull(rubro);
	}
}
