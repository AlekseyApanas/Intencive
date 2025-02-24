package src.ru.aston.apanas_ak.task3;

import java.util.Objects;

public class User {
    private int age;
    private String city;

    public User(int age) {
        this.age = age;
    }

    public User(int age, String city) {
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, city);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
