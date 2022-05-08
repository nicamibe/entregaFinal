package io.slimmens.entregafinal.domain.entities;


import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import java.util.Set;

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

   @OneToMany(mappedBy = "factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<DetalleFactura> detalleFactura;

   /* public DetalleFactura agregarDetalle(DetalleFactura detalleFactura) {
    	getDetalleFactura().add(detalleFactura);
    	detalleFactura.setFactura(this);
    	return detalleFactura;
	}*/


	public Factura() {
		// Constructor requerido por JPA.
	}

	public Factura(int id, Cliente cliente, Date fecha) {
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
	}
}
