package ru.aston.apanas_ak.task1.dto;

import java.util.Objects;

public class UserDTO {
    private int age;
    private String name;
    private String surName;

    public UserDTO(int age, String name, String surName) {
        this.age = age;
        this.name = name;
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(surName, user.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surName);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
