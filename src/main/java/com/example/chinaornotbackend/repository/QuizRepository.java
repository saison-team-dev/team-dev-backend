package com.example.chinaornotbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.chinaornotbackend.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

  Optional<Quiz> findByQuestion(String question);

  // ランダムに10個のクイズを取得
  @Query(value = "SELECT * FROM quizzes ORDER BY RANDOM() LIMIT 10;", nativeQuery = true)
  List<Quiz> findAllWithAnswers();
}
