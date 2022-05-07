package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductoModel {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("descripcion")
	private String descripcion;

	@JsonProperty("precio")
	private Double precio;

	@JsonProperty("cantidad_disponible")
	private Integer cantidadDisponible;

}
