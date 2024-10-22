package com.felipe.sale_service.application.ports.out;

import com.felipe.sale_service.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
