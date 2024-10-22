package com.felipe.sale_service.application.core.usecase;

import com.felipe.sale_service.application.core.domain.Sale;
import com.felipe.sale_service.application.core.domain.enums.SaleEvent;
import com.felipe.sale_service.application.core.domain.enums.SaleStatus;
import com.felipe.sale_service.application.ports.out.SaveSaleOutputPort;
import com.felipe.sale_service.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase {

    private final SaveSaleOutputPort saveSaleOutputPort;

    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
            SendCreatedSaleOutputPort sendCreatedSaleOutputPort
    ) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
