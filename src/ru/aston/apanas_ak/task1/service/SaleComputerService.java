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
        return saleComp.stream().sorted(new SortByUserSurname()).toList();
    }

    @Override
    public BigDecimal moneyForSale() {
        if (saleComp.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return saleComp.stream().map(WarehouseDTO::getSalePrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
