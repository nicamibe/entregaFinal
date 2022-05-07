package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DisponibilidadModel {

	@JsonProperty("variacion")
	private Integer variacion;
}
