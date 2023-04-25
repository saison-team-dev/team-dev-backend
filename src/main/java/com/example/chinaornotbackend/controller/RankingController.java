package com.example.chinaornotbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chinaornotbackend.response.RankingResponse;
import com.example.chinaornotbackend.service.RankingService;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {
  @Autowired
  private RankingService rankingService;

  @GetMapping
  public ResponseEntity<List<RankingResponse>> getRankings() {
    List<RankingResponse> rankings = rankingService.getRankings();
    return new ResponseEntity<>(rankings, HttpStatus.OK);
  }

}
