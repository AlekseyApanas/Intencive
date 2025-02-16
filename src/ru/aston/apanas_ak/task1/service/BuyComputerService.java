package ru.aston.apanas_ak.task1.service;

import ru.aston.apanas_ak.task1.core.exception.CheckUuidException;
import ru.aston.apanas_ak.task1.dto.WarehouseDTO;
import ru.aston.apanas_ak.task1.service.api.IBuyComputerService;
import ru.aston.apanas_ak.task1.util.SortByUserSurname;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuyComputerService implements IBuyComputerService {
    private final List<WarehouseDTO> warehouse = new ArrayList<>();

    @Override
    public void buyComp(WarehouseDTO buyComputerDTO) {
        warehouse.add(buyComputerDTO);
    }

    @Override
    public BigDecimal moneyInvestedInWarehouse() {
        if (warehouse.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return warehouse.stream().map(WarehouseDTO::getPurchasePrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<WarehouseDTO> getComputersInWarehouse() {
        return warehouse.stream().sorted(new SortByUserSurname()).toList();
    }

    @Override
    public void discount(UUID uuid) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        if (warehouse.stream().map(WarehouseDTO::getUuid).toList().contains(uuid)) {
            warehouse.replaceAll(e -> {
                if (e.getUuid().equals(uuid) && e.getDateOfReceipt().getYear() != year) {
                    e.setSalePrice(e.getSalePrice().multiply(BigDecimal.valueOf(0.9)));
                }
                return e;
            });
        } else {
            throw new CheckUuidException("Такого uuid не существует");
        }
    }

    @Override
    public void saleComp(UUID uuid) {
        if (warehouse.stream().map(WarehouseDTO::getUuid).toList().contains(uuid)) {
            warehouse.removeIf(warehouseDTO -> warehouseDTO.getUuid().equals(uuid));
        } else {
            throw new CheckUuidException("Такого uuid не существует");
        }
    }

    @Override
    public WarehouseDTO getComp(UUID uuid) {
        return warehouse.stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElseThrow(() -> new CheckUuidException("Такого uuid не существует"));

    }
}
