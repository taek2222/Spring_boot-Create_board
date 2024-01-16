package com.example.board.repository;

import com.example.board.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

    @Override
    ArrayList<Pizza> findAll();
}
