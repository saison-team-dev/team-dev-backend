package com.example.chinaornotbackend.service;

import com.example.chinaornotbackend.response.RankingResponse;
import java.util.List;

public interface RankingService {
	List<RankingResponse> getRankings();
}

