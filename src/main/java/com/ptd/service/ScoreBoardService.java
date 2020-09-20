package com.ptd.service;

import com.ptd.model.ScoreBoardDTO;

public interface ScoreBoardService {
    public ScoreBoardDTO getScoreBoardById(int boardId);

    public ScoreBoardDTO getScoreBoardByMatchId(int matchId);

    public void addScoreBoard(ScoreBoardDTO scoreBoardDTO);

    public void updateScoreBoard(ScoreBoardDTO scoreBoardDTO);
}
