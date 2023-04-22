package com.example.chinaornotbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.chinaornotbackend.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

  Optional<Quiz> findByQuestion(String question);

  @Query("SELECT q FROM Quiz q JOIN FETCH q.answer")
  List<Quiz> findAllWithAnswers(Pageable pageable);
}
