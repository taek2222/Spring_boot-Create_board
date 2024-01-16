package com.example.board.api;

import com.example.board.dto.PizzaForm;
import com.example.board.entity.Pizza;
import com.example.board.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    private PizzaService pizzaService;

    // 1. 데이터 생성
    @PostMapping("/api/pizza")
    public ResponseEntity<Pizza> create(@RequestBody PizzaForm dto) {
        Pizza created = pizzaService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 2. 데이터 조회
    @GetMapping("/api/pizza")
    public List<Pizza> read() {
        return pizzaService.read();
    }

    @GetMapping("/api/pizza/{pizza_id}")
    public Pizza read_id(@PathVariable Long pizza_id) {
        return pizzaService.read_id(pizza_id);
    }

    // 3. 데이터 수정
    @PatchMapping("/api/pizza/{pizza_id}")
    public ResponseEntity<Pizza> patch(@PathVariable Long pizza_id, @RequestBody PizzaForm dto) {
        Pizza updated = pizzaService.patch(pizza_id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 4. 데이터 삭제
    @DeleteMapping("/api/pizza/{pizza_id}")
    public  ResponseEntity<Pizza> delete(@PathVariable Long pizza_id) {
        Pizza deleted = pizzaService.delete(pizza_id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
