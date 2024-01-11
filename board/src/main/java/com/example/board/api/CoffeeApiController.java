package com.example.board.api;

import com.example.board.dto.CoffeeForm;
import com.example.board.entity.Coffee;
import com.example.board.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    //GET
    @GetMapping("/api/coffee")
    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/api/coffee/{id}")
    public Coffee show(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping("/api/coffee")
    public  Coffee create(@RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        return coffeeRepository.save(coffee);
    }

    //PATCH
    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();

        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null || id != coffee.getId()) {
            log.info("잘못된 요청 id: {}, coffee: {}", id, coffee.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    //DELETE
    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
