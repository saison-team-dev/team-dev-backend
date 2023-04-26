package com.example.chinaornotbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chinaornotbackend.exception.RankingNotFoundExeption;
//import com.example.chinaornotbackend.model.Ranking;
import com.example.chinaornotbackend.repository.RankingRepository;
import com.example.chinaornotbackend.response.RankingResponse;

@Service
public class RankingServiceImpl implements RankingService {
  @Autowired
  private RankingRepository quizRepository;

  @Override
  public List<RankingResponse> getRankings() {
    List<RankingResponse> rankings = quizRepository.getTop10Scores();

    if (rankings.isEmpty()) {
      throw new RankingNotFoundExeption("ランキングが取得できまませんでした。");
    } else {
      return rankings;
    }
  }
}
