package io.slimmens.entregafinal.controllers.mappers;


import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.domain.entities.Factura;
import io.slimmens.entregafinal.services.impl.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Factura")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

   /* @PostMapping("7crearFactura")
    public Factura crearFactrua(@RequestBody FacturaModel facturaModel){
        return facturaService.crearFacturas(facturaModel);

    }*/



}
