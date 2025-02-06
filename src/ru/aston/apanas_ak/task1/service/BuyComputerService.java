package ru.aston.apanas_ak.task1.service;

import ru.aston.apanas_ak.task1.dto.WarehouseDTO;
import ru.aston.apanas_ak.task1.service.api.IBuyComputerService;
import ru.aston.apanas_ak.task1.util.SortByUserSurname;

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
    public double moneyInvestedInWarehouse() {
        double money = 0;
        for (WarehouseDTO buyComputerDTO : warehouse) {
            money += buyComputerDTO.getPurchasePrice();
        }
        return money;
    }

    @Override
    public List getComputersInWarehouse() {
        List<WarehouseDTO> sortList = new ArrayList<>(warehouse.stream().toList());
        sortList.sort(new SortByUserSurname());
        return sortList;
    }

    @Override
    public void discount(UUID uuid) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        for (WarehouseDTO buyComputerDTO : warehouse) {
            if (buyComputerDTO.getUuid().equals(uuid)) {
                if (buyComputerDTO.getDateOfReceipt().getYear() != year) {
                    buyComputerDTO.setSalePrice(buyComputerDTO.getSalePrice() * 0.9);
                    break;
                }
                break;
            }
        }
    }

    @Override
    public void saleComp(UUID uuid) {
        for (WarehouseDTO warehouseDTO : warehouse) {
            if (warehouseDTO.getUuid().equals(uuid)) {
                warehouse.remove(warehouseDTO);
            }
        }
    }

    @Override
    public WarehouseDTO getComp(UUID uuid) {
        for (WarehouseDTO warehouseDTO : warehouse) {
            if (warehouseDTO.getUuid().equals(uuid)) {
                return warehouseDTO;
            }
        }
        return null;
    }
}
