package ru.aston.apanas_ak.task1.dto;

import java.util.Objects;

public class ComputerDTO {

    private String namePC;
    private int yearOfPublication;

    public ComputerDTO(String namePC, int yearOfPublication) {
        this.namePC = namePC;
        this.yearOfPublication = yearOfPublication;
    }

    public String getNamePC() {
        return namePC;
    }

    public void setNamePC(String namePC) {
        this.namePC = namePC;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerDTO pc = (ComputerDTO) o;
        return yearOfPublication == pc.yearOfPublication && Objects.equals(namePC, pc.namePC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePC, yearOfPublication);
    }

    @Override
    public String toString() {
        return "ComputerDTO{" +
                "namePC='" + namePC + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}
