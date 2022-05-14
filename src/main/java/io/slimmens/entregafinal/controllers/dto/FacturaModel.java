package io.slimmens.entregafinal.controllers.dto;
import lombok.Data;

import java.util.List;

@Data
public class FacturaModel {

    ClienteModel cliente;
    int idEmpresa;
    List<ProductoFacturadoModel> productos;




}
