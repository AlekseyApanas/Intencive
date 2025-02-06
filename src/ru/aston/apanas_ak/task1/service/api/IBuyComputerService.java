package ru.aston.apanas_ak.task1.service.api;

import ru.aston.apanas_ak.task1.dto.WarehouseDTO;

import java.util.List;
import java.util.UUID;

public interface IBuyComputerService {
    void buyComp(WarehouseDTO buyComputerDTO);

    double moneyInvestedInWarehouse();

    List getComputersInWarehouse();

    void saleComp(UUID uuid);

     WarehouseDTO getComp(UUID uuid);

    void discount();
}
