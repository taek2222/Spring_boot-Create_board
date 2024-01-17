package com.example.Practice.dto;

import com.example.Practice.entity.Coffee;

public class CoffeeForm {
    private Long id;
    private String name;
    private String price;

    public CoffeeForm(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoffeeForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
