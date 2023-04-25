package com.example.chinaornotbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chinaornotbackend.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
  List<Score> findByUserId(Long userId);
}
