package ru.aston.apanas_ak.task1.service;

import ru.aston.apanas_ak.task1.dto.WarehouseDTO;
import ru.aston.apanas_ak.task1.service.api.IBuyComputerService;
import ru.aston.apanas_ak.task1.service.api.ISaleComputerService;
import ru.aston.apanas_ak.task1.util.SortByUserSurname;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SaleComputerService implements ISaleComputerService {
    private final List<WarehouseDTO> saleComp = new ArrayList<>();
    private final IBuyComputerService iBuyComputerService;

    public SaleComputerService(IBuyComputerService iBuyComputerService) {
        this.iBuyComputerService = iBuyComputerService;
    }

    @Override
    public void saleComp(UUID uuid) {
        saleComp.add(iBuyComputerService.getComp(uuid));
        iBuyComputerService.discount(uuid);
        iBuyComputerService.saleComp(uuid);
    }

    @Override
    public List<WarehouseDTO> getInfoSaleComp() {
        List<WarehouseDTO> sortList = new ArrayList<>(saleComp.stream().toList());
        sortList.sort(new SortByUserSurname());
        return sortList;
    }

    @Override
    public BigDecimal moneyForSale() {
        BigDecimal money = BigDecimal.valueOf(0);
        for (WarehouseDTO warehouseDTO : saleComp) {
            money = money.add(warehouseDTO.getSalePrice());
        }
        return money;
    }
}
