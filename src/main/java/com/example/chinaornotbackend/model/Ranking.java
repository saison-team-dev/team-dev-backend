package com.example.chinaornotbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="scores")
public class Ranking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User userId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "name")
  private User name;
  
  @Column(name = "total_score", nullable = false)
  private int totalScore;
  
  @Column(name = "correct_rate", nullable = false)
  private int correctRate;
  
  @Column(name = "rank", nullable = false)
  private int rank;
  
  public User getUserId() {
	  return userId;
  }
  
  public User getName() {
	  return name;
  }
  
  public int getTotalScore() {
	  return totalScore;
  }
  
  public int getCorrectRate() {
	  return correctRate;
  }
  
}
