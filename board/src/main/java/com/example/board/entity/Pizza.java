package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public Pizza(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void patch(Pizza pizza) {
        if(pizza.name != null)
            this.name = pizza.name;
        if(pizza.price != null)
            this.price = pizza.price;
    }
}
