package ru.aston.apanas_ak.task1.service.api;

import ru.aston.apanas_ak.task1.dto.WarehouseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IBuyComputerService {
    void buyComp(WarehouseDTO buyComputerDTO);

    BigDecimal moneyInvestedInWarehouse();

    List<WarehouseDTO> getComputersInWarehouse();

    void saleComp(UUID uuid);

    WarehouseDTO getComp(UUID uuid);

    void discount(UUID uuid);
}
