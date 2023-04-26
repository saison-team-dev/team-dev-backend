package com.example.chinaornotbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.chinaornotbackend.model.Score;
import com.example.chinaornotbackend.response.RankingResponse;

@Repository
public interface RankingRepository extends JpaRepository<Score, Long> {

//  Optional<Ranking> findByQuestion(String question);

  // ランダムに10個のクイズを取得
  @Query(value = "SELECT * FROM scores ORDER BY total_score DESC LIMIT 10;", nativeQuery = true)
  List<RankingResponse> getTop10Scores();
}
