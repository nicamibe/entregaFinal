package io.slimmens.entregafinal.domain.entities;

import java.util.Objects;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellido", nullable = false)
	private String apellido;

	@Column(name = "dni")//, nullable = false)
	private Integer dni;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	public Cliente() {
		// Constructor requerido por JPA.
	}

	public Cliente(String nombre, String apellido, Integer dni, String direccion) {
		this.nombre = Objects.requireNonNull(nombre);
		this.apellido = Objects.requireNonNull(apellido);
		this.dni = Objects.requireNonNull(dni);
		this.direccion = Objects.requireNonNull(direccion);
	}
	
}
