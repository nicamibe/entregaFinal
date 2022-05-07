package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmpresaModel {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("rubro")
	private String rubro;

}
