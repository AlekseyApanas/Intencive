package ru.aston.apanas_ak.task1.service;

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
        BigDecimal money = BigDecimal.valueOf(0);
        for (WarehouseDTO buyComputerDTO : warehouse) {
            money = money.add(buyComputerDTO.getPurchasePrice());
        }
        return money;
    }

    @Override
    public List<WarehouseDTO> getComputersInWarehouse() {
        List<WarehouseDTO> sortList = new ArrayList<>(warehouse.stream().toList());
        sortList.sort(new SortByUserSurname());
        return sortList;
    }

    @Override
    public void discount(UUID uuid) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        for (WarehouseDTO buyComputerDTO : warehouse) {
            if (buyComputerDTO.getUuid().equals(uuid) && buyComputerDTO.getDateOfReceipt().getYear() != year) {
                buyComputerDTO.setSalePrice(buyComputerDTO.getSalePrice().multiply(BigDecimal.valueOf(0.9)));
                break;
            }
        }
    }

    @Override
    public void saleComp(UUID uuid) {
        warehouse.removeIf(warehouseDTO -> warehouseDTO.getUuid().equals(uuid));
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
