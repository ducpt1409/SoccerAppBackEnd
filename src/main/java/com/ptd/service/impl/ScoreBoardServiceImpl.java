package com.ptd.service.impl;

import com.ptd.dao.MatchDAO;
import com.ptd.dao.ScoreBoardDAO;
import com.ptd.entity.Match;
import com.ptd.entity.ScoreBoard;
import com.ptd.model.MatchDTO;
import com.ptd.model.ScoreBoardDTO;
import com.ptd.service.MatchService;
import com.ptd.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

    @Autowired
    ScoreBoardDAO scoreBoardDAO;
    @Autowired
    MatchDAO matchDAO;

    @Autowired
    MatchService matchService;


    public ScoreBoardDTO toDTO(ScoreBoard scoreBoard) {
        ScoreBoardDTO scoreBoardDTO = new ScoreBoardDTO();
        MatchDTO matchDTO = matchService.getMatchById(scoreBoard.getMatch().getId());

        scoreBoardDTO.setId(scoreBoard.getId());
        scoreBoardDTO.setMatchDTO(matchDTO);
        scoreBoardDTO.setTotalMinute(scoreBoard.getTotalMinute());
        scoreBoardDTO.setPenaltyScore(scoreBoard.getPenaltyScore());
        scoreBoardDTO.setNote(scoreBoard.getNote());
        scoreBoardDTO.setFinalScore(scoreBoard.getFinalScore());

        return scoreBoardDTO;
    }

    @Override
    public ScoreBoardDTO getScoreBoardById(int boardId) {
        ScoreBoard scoreBoard = scoreBoardDAO.getScoreBoardById(boardId);
        ScoreBoardDTO scoreBoardDTO = toDTO(scoreBoard);

        return scoreBoardDTO;
    }

    @Override
    public ScoreBoardDTO getScoreBoardByMatchId(int matchId) {
        ScoreBoard scoreBoard = scoreBoardDAO.getScoreBoardByMatchId(matchId);
        ScoreBoardDTO scoreBoardDTO = toDTO(scoreBoard);

        return scoreBoardDTO;
    }

    @Override
    public void addScoreBoard(ScoreBoardDTO scoreBoardDTO) {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setFinalScore(scoreBoardDTO.getFinalScore());
        scoreBoard.setMatch(matchDAO.getMatchById(scoreBoardDTO.getMatchDTO().getId()));
        scoreBoard.setNote(scoreBoardDTO.getNote());
        scoreBoard.setPenaltyScore(scoreBoardDTO.getPenaltyScore());
        scoreBoard.setTotalMinute(scoreBoardDTO.getTotalMinute());

        scoreBoardDAO.addScoreBoard(scoreBoard);
    }

    @Override
    public void updateScoreBoard(ScoreBoardDTO scoreBoardDTO) {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.setId(scoreBoardDTO.getId());
        scoreBoard.setFinalScore(scoreBoardDTO.getFinalScore());
        scoreBoard.setMatch(matchDAO.getMatchById(scoreBoardDTO.getMatchDTO().getId()));
        scoreBoard.setNote(scoreBoardDTO.getNote());
        scoreBoard.setPenaltyScore(scoreBoardDTO.getPenaltyScore());
        scoreBoard.setTotalMinute(scoreBoardDTO.getTotalMinute());

        scoreBoardDAO.updateScoreBoard(scoreBoard);
    }
}
