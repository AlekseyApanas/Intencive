package ru.aston.apanas_ak.task1.service.api;


import java.util.List;
import java.util.UUID;

public interface ISaleComputerService {
    void saleComp(UUID uuid);

    List getInfoSaleComp();

    double moneyForSale();

}
