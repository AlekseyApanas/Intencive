package ru.aston.apanas_ak.task1.util;

import ru.aston.apanas_ak.task1.dto.WarehouseDTO;

import java.util.Comparator;

public class SortByUserSurname implements Comparator<WarehouseDTO> {
    @Override
    public int compare(WarehouseDTO o1, WarehouseDTO o2) {
        return o1.getUser().getSurName().compareTo(o2.getUser().getSurName());
    }
}
