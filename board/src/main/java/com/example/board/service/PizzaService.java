package com.example.board.service;

import com.example.board.dto.PizzaForm;
import com.example.board.entity.Pizza;
import com.example.board.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    // Create
    public Pizza create(PizzaForm dto) {
        Pizza pizza = dto.toEntity();
        if(pizza.getId() != null)
            return null;
        return pizzaRepository.save(pizza);
    }
}
