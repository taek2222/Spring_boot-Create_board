package com.example.board.dto;

import com.example.board.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PizzaForm {
    private Long id;
    private String name;
    private String price;

    public Pizza toEntity() {
        return new Pizza(id, name, price);
    }
}
