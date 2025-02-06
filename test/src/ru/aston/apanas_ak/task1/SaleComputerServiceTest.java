package src.ru.aston.apanas_ak.task1;

import org.junit.jupiter.api.Test;
import ru.aston.apanas_ak.task1.dto.ComputerDTO;
import ru.aston.apanas_ak.task1.dto.UserDTO;
import ru.aston.apanas_ak.task1.dto.WarehouseDTO;
import ru.aston.apanas_ak.task1.service.BuyComputerService;
import ru.aston.apanas_ak.task1.service.SaleComputerService;
import ru.aston.apanas_ak.task1.service.api.IBuyComputerService;
import ru.aston.apanas_ak.task1.service.api.ISaleComputerService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SaleComputerServiceTest {
    private final IBuyComputerService iBuyComputerService = new BuyComputerService();
    private final ISaleComputerService iSaleComputerService = new SaleComputerService(iBuyComputerService);

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
        iSaleComputerService.saleComp(UUID.fromString(uuid1));
        boolean result = iBuyComputerService.getComputersInWarehouse().size() == 3;
        assertTrue(result);
    }

    @Test
    public void getInfoSaleComp() {
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
        iSaleComputerService.saleComp(UUID.fromString(uuid1));
        boolean result = iSaleComputerService.getInfoSaleComp().size() == 1;
        assertTrue(result);
    }

    @Test
  public   void moneyForSale() {
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
        iSaleComputerService.saleComp(UUID.fromString(uuid1));
        boolean result = iSaleComputerService.moneyForSale() == 150;
        assertTrue(result);
    }
}
