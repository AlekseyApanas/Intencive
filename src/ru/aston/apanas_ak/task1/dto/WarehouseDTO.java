package ru.aston.apanas_ak.task1.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class WarehouseDTO {
    private UUID uuid;

    private UserDTO user;
    private ComputerDTO pc;
    private BigDecimal purchasePrice;
    private LocalDateTime dateOfReceipt;
    private BigDecimal salePrice;

    public WarehouseDTO(UserDTO user, ComputerDTO pc, BigDecimal purchasePrice) {
        this.uuid = UUID.randomUUID();
        this.user = user;
        this.pc = pc;
        this.salePrice = purchasePrice.multiply(BigDecimal.valueOf(1.5));
        this.dateOfReceipt = LocalDateTime.now();
        this.purchasePrice = purchasePrice;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ComputerDTO getPc() {
        return pc;
    }

    public void setPc(ComputerDTO pc) {
        this.pc = pc;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDateTime getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDateTime dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseDTO that = (WarehouseDTO) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(user, that.user) && Objects.equals(pc, that.pc) && Objects.equals(purchasePrice, that.purchasePrice) && Objects.equals(dateOfReceipt, that.dateOfReceipt) && Objects.equals(salePrice, that.salePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, user, pc, purchasePrice, dateOfReceipt, salePrice);
    }

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "uuid=" + uuid +
                ", user=" + user +
                ", pc=" + pc +
                ", purchasePrice=" + purchasePrice +
                ", dateOfReceipt=" + dateOfReceipt +
                ", salePrice=" + salePrice +
                '}';
    }
}
