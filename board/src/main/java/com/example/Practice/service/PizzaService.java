package com.example.Practice.service;

import com.example.Practice.repository.PizzaRepository;
import com.example.Practice.dto.PizzaForm;
import com.example.Practice.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Read
    public List<Pizza> read() {
        return pizzaRepository.findAll();
    }

    // Read_id
    public Pizza read_id(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    // Update
    public Pizza patch(Long pizzaId, PizzaForm dto) {
        Pizza pizza = dto.toEntity();

        System.out.println(pizza.toString());
        Pizza target = pizzaRepository.findById(pizzaId).orElse(null);
        if(target == null || !pizzaId.equals(pizza.getId()))
            return null;

        target.patch(pizza);
        return pizzaRepository.save(target);
    }

    // Delete
    public Pizza delete(Long pizzaId) {
        Pizza target = pizzaRepository.findById(pizzaId).orElse(null);
        if(target == null)
            return null;
        pizzaRepository.delete(target);
        return target;
    }
}
