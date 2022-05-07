package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorModel {

	@JsonProperty("mensaje")
	private String mensaje;

}
