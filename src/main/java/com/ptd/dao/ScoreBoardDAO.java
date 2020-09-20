package com.ptd.dao;

import com.ptd.entity.ScoreBoard;

public interface ScoreBoardDAO {
    public void addScoreBoard(ScoreBoard scoreBoard);

    public void updateScoreBoard(ScoreBoard scoreBoard);

    public ScoreBoard getScoreBoardById(int scoreBoardId);

    public ScoreBoard getScoreBoardByMatchId(int matchId);
}
