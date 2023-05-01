package com.example.chinaornotbackend.response;

import lombok.Data;

@Data
public class RankingResponse {
  private Long userId;
  private String name;
  private int totalScore;
  private int rank;

  public RankingResponse(
      Long userId,
      String name,
      int totalScore,
      int rank) {
    this.userId = userId;
    this.name = name;
    this.totalScore = totalScore;
    this.rank = rank;
  }
}
