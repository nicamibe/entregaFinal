package io.slimmens.entregafinal.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class CollectionModel<T> {

	@JsonProperty("items")
	private List<T> items;

	@JsonProperty("total")
	private long total;

}
