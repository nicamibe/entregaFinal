package io.slimmens.entregafinal.controllers.mappers;


import io.slimmens.entregafinal.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
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
