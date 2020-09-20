package com.ptd.dao.impl;

import com.ptd.dao.ScoreBoardDAO;
import com.ptd.entity.ScoreBoard;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ScoreBoardDAOImpl implements ScoreBoardDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addScoreBoard(ScoreBoard scoreBoard) {
        entityManager.persist(scoreBoard);
    }

    @Override
    public void updateScoreBoard(ScoreBoard scoreBoard) {
        entityManager.merge(scoreBoard);
    }

    @Override
    public ScoreBoard getScoreBoardById(int scoreBoardId) {
        return entityManager.find(ScoreBoard.class, scoreBoardId);
    }

    @Override
    public ScoreBoard getScoreBoardByMatchId(int matchId) {
        String jql = "select e from ScoreBoard e where e.match.id = " + matchId;
        return entityManager.createQuery(jql, ScoreBoard.class).getSingleResult();
    }

}
