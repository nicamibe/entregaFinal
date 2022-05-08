package io.slimmens.entregafinal.domain.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

//nueva clase


@Getter
@Setter
@Entity

@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;




	public Factura() {
		// Constructor requerido por JPA.
	}

	public Factura(int id, Cliente cliente, Date fecha) {
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
	}
}
