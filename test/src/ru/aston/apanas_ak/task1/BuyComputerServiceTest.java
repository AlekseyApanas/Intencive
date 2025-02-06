package src.ru.aston.apanas_ak.task1;


import org.junit.jupiter.api.Test;
import ru.aston.apanas_ak.task1.dto.ComputerDTO;
import ru.aston.apanas_ak.task1.dto.UserDTO;
import ru.aston.apanas_ak.task1.dto.WarehouseDTO;
import ru.aston.apanas_ak.task1.service.BuyComputerService;
import ru.aston.apanas_ak.task1.service.api.IBuyComputerService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyComputerServiceTest {
    private final IBuyComputerService iBuyComputerService = new BuyComputerService();

    @Test
    public void buyComp() {
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Aleksey", "Apanas"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(16, "Grisha", "Pupkin"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(17, "Misha", "Trik"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Vitya", "Aka"), new ComputerDTO("Acer", 2022), 100.0));
        boolean result = iBuyComputerService.getComputersInWarehouse().size() == 4;
        assertTrue(result);
    }


    @Test
    public void moneyInvestedInWarehouse() {
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Aleksey", "Apanas"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(16, "Grisha", "Pupkin"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(17, "Misha", "Trik"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Vitya", "Aka"), new ComputerDTO("Acer", 2022), 100.0));
        boolean result = iBuyComputerService.moneyInvestedInWarehouse() == 400.0;
        assertTrue(result);
    }

    @Test
    public void getComputersInWarehouse() {
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Aleksey", "Apanas"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(16, "Grisha", "Pupkin"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(17, "Misha", "Trik"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Vitya", "Aka"), new ComputerDTO("Acer", 2022), 100.0));
        boolean result = iBuyComputerService.moneyInvestedInWarehouse() == 400.0;
        assertTrue(result);
    }

    @Test
    public void discount() {
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Aleksey", "Apanas"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(16, "Grisha", "Pupkin"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(17, "Misha", "Trik"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Vitya", "Aka"), new ComputerDTO("Acer", 2022), 100.0));
        List<WarehouseDTO> list = iBuyComputerService.getComputersInWarehouse();
        String uuid1 = "5160a508-c6cd-4299-85ea-182cf7ba056d";
        for (WarehouseDTO buyComputerDTO : list) {
            if (Objects.equals("Misha", buyComputerDTO.getUser().getName())) {
                buyComputerDTO.setDateOfReceipt(LocalDateTime.of(2018, Month.MAY, 15, 12, 15, 00));
                buyComputerDTO.setUuid(UUID.fromString(uuid1));
            }
        }
        iBuyComputerService.discount(UUID.fromString(uuid1));
        double moneySale = 0;
        for (WarehouseDTO warehouseDTO : list) {
            moneySale += warehouseDTO.getSalePrice();
        }
        boolean result = moneySale == 585.0;
        assertTrue(result);
    }

    @Test
    public void saleComp() {
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Aleksey", "Apanas"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(16, "Grisha", "Pupkin"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(17, "Misha", "Trik"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Vitya", "Aka"), new ComputerDTO("Acer", 2022), 100.0));
        List<WarehouseDTO> list = iBuyComputerService.getComputersInWarehouse();
        String uuid1 = "5160a508-c6cd-4299-85ea-182cf7ba056d";
        for (WarehouseDTO buyComputerDTO : list) {
            if (Objects.equals("Misha", buyComputerDTO.getUser().getName())) {
                buyComputerDTO.setUuid(UUID.fromString(uuid1));
            }
        }
        iBuyComputerService.saleComp(UUID.fromString(uuid1));
        boolean result = iBuyComputerService.getComputersInWarehouse().size() == 3;
        assertTrue(result);
    }

    @Test
    public void getComp() {
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Aleksey", "Apanas"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(16, "Grisha", "Pupkin"), new ComputerDTO("Acer", 2022), 100.0));
        WarehouseDTO warehouseDTO = (new WarehouseDTO(new UserDTO(17, "Misha", "Trik"), new ComputerDTO("Acer", 2022), 100.0));
        iBuyComputerService.buyComp(warehouseDTO);
        iBuyComputerService.buyComp(new WarehouseDTO(new UserDTO(15, "Vitya", "Aka"), new ComputerDTO("Acer", 2022), 100.0));
        List<WarehouseDTO> list = iBuyComputerService.getComputersInWarehouse();
        String uuid1 = "5160a508-c6cd-4299-85ea-182cf7ba056d";
        for (WarehouseDTO buyComputerDTO : list) {
            if (Objects.equals("Misha", buyComputerDTO.getUser().getName())) {
                buyComputerDTO.setUuid(UUID.fromString(uuid1));
            }
        }
        boolean result = Objects.equals(iBuyComputerService.getComp(UUID.fromString(uuid1)), warehouseDTO);
        assertTrue(result);
    }
}
