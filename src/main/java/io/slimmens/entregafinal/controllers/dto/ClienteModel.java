package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClienteModel {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("apellido")
	private String apellido;

	@JsonProperty("dni")
	private Integer dni;

	@JsonProperty("direccion")
	private String direccion;

}
