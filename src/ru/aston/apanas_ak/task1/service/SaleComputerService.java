package ru.aston.apanas_ak.task1.service;

import ru.aston.apanas_ak.task1.dto.WarehouseDTO;
import ru.aston.apanas_ak.task1.service.api.IBuyComputerService;
import ru.aston.apanas_ak.task1.service.api.ISaleComputerService;
import ru.aston.apanas_ak.task1.util.SortByUserSurname;

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
    public List getInfoSaleComp() {
        List<WarehouseDTO> sortList = new ArrayList<>(saleComp.stream().toList());
        sortList.sort(new SortByUserSurname());
        return sortList;
    }

    @Override
    public double moneyForSale() {
        double money = 0;
        for (WarehouseDTO warehouseDTO : saleComp) {
            money += warehouseDTO.getSalePrice();
        }
        return money;
    }
}
