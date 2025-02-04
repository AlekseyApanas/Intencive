package ru.aston.apanas_ak.task1.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class WarehouseDTO {
    private UUID uuid;

    private UserDTO user;
    private ComputerDTO pc;
    private double purchasePrice;
    private LocalDateTime dateOfReceipt;
    private double salePrice;

    public WarehouseDTO(UserDTO user, ComputerDTO pc, double purchasePrice) {
        this.uuid = UUID.randomUUID();
        this.user = user;
        this.pc = pc;
        this.salePrice = purchasePrice * 1.5;
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

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDateTime getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDateTime dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
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
        return Double.compare(that.purchasePrice, purchasePrice) == 0 && Double.compare(that.salePrice, salePrice) == 0 && Objects.equals(uuid, that.uuid) && Objects.equals(user, that.user) && Objects.equals(pc, that.pc) && Objects.equals(dateOfReceipt, that.dateOfReceipt);
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
