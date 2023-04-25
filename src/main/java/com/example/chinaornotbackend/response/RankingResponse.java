package com.example.chinaornotbackend.response;

import com.example.chinaornotbackend.model.User;
import lombok.Data;

@Data
public class RankingResponse {
  private User userId;
  private User name;
  private int totalScore;
  private int correctRate;
  private int rank;

  public RankingResponse(User userId, User name, int totalScore, int correctRate, int rank) {
	  this.userId = userId;
	  this.name = name;
	  this.totalScore = totalScore;
	  this.correctRate = correctRate;
	  this.rank = rank;
  }
}
