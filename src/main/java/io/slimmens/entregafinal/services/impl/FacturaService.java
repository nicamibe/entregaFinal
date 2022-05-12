package io.slimmens.entregafinal.services.impl;

import io.slimmens.entregafinal.controllers.dto.FacturaModel;
import io.slimmens.entregafinal.domain.entities.Cliente;
import org.springframework.transaction.annotation.Transactional;

public interface FacturaService {
    @Transactional
    Cliente facturarProducto(FacturaModel facturaModel);
}
