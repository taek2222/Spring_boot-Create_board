package com.example.board.api;

import com.example.board.dto.PizzaForm;
import com.example.board.entity.Pizza;
import com.example.board.service.PizzaService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    // 3. 데이터 수정
    // 4. 데이터 삭제
}
