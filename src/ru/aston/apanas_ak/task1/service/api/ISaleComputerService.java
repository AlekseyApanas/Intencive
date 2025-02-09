package ru.aston.apanas_ak.task1.service.api;


import ru.aston.apanas_ak.task1.dto.WarehouseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ISaleComputerService {
    void saleComp(UUID uuid);

    List<WarehouseDTO> getInfoSaleComp();

    BigDecimal moneyForSale();

}
