package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnswerRepositoryy extends JpaRepository<Answer, Long> {
    List<Answer> finByQuetionId(Long questionId);
}
