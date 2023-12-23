package com.example.board.repository;

import com.example.board.entity.Members;
import org.springframework.data.repository.CrudRepository;

public interface MembersRepository extends CrudRepository<Members, Long> {
}
