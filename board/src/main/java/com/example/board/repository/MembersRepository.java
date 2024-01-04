package com.example.board.repository;

import com.example.board.entity.Members;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MembersRepository extends CrudRepository<Members, Long> {
    @Override
    ArrayList<Members> findAll();
}
