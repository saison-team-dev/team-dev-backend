package com.example.chinaornotbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chinaornotbackend.exception.RankingNotFoundExeption;
import com.example.chinaornotbackend.model.Ranking;
import com.example.chinaornotbackend.repository.RankingRepository;
import com.example.chinaornotbackend.response.RankingResponse;

@Service
public class RankingServiceImpl implements RankingService {
  @Autowired
  private RankingRepository rankingRepository;

  @Override
  public List<RankingResponse> getRankings() {
    List<Ranking> rankings = rankingRepository.findTop10Scores();

     List<RankingResponse> rankingResponses = new ArrayList<>();
//    for (Ranking ranking: rankings) {
//      RankingResponse rankingResponse = new RankingResponse(
//    		  ranking.getUserId(), 
//    		  ranking.getName(), 
//    		  ranking.getTotalScore().,
//    		  ranking.getCorrectRate(),
//    		  ranking.getRank()
//    		  );
//      rankingResponses.add(rankingResponse);
//    }
     for (int idx=0; idx<10; idx++) {
       RankingResponse rankingResponse = new RankingResponse(
		  rankings.get(idx).getUserId(), 
		  rankings.get(idx).getName(), 
		  rankings.get(idx).getTotalScore(),
		  rankings.get(idx).getCorrectRate(),
		  idx+1
		  );
       	rankingResponses.add(rankingResponse);
    	 
     }

    if (rankings.isEmpty()) {
      throw new RankingNotFoundExeption("クイズが見つかりませんでした。");
    } else {
      return rankingResponses;
    }
  }
}
