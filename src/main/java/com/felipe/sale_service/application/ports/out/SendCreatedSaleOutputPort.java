package com.felipe.sale_service.application.ports.out;

import com.felipe.sale_service.application.core.domain.Sale;
import com.felipe.sale_service.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);

}
