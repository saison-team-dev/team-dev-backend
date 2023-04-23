package com.example.chinaornotbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chinaornotbackend.model.Score;
import com.example.chinaornotbackend.repository.ScoreRepository;

@Service
public class ScoreServiceImpl implements ScoreService {
  @Autowired
  private ScoreRepository scoreRepository;

  @Override
  public Long createScore(Score score) {
    Score newScore = scoreRepository.save(score);
    return newScore.getId();
  }

  @Override
  public List<Score> getScoreByUserId(Long userId) {
    List<Score> scores = scoreRepository.findByUserId(userId);
    return scores;
  }

}
