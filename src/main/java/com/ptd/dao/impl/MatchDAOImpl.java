package com.ptd.dao.impl;

import com.ptd.dao.MatchDAO;
import com.ptd.entity.Match;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MatchDAOImpl implements MatchDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void matchMaking(Match match) {
        entityManager.persist(match);
    }

    @Override
    public List<Match> getCreatedMatch(int teamId) {
        String jql = "select e from Match e where e.team.id = " + teamId + " or e.team_join = " + teamId;
        return entityManager.createQuery(jql, Match.class).getResultList();
    }

    @Override
    public Match getMatchById(int id) {
        return entityManager.find(Match.class, id);
    }

    @Override
    public void updateStatusMatch(int matchId, int status) {
        String jql = "update Match e set e.status =" + status + " where e.id = " + matchId;
        entityManager.createQuery(jql).executeUpdate();
    }

    @Override
    public void deleteMatch(int matchId) {
        Match match = getMatchById(matchId);
        entityManager.remove(match);
    }

    @Override
    public void updateMatch(Match match) {
        entityManager.merge(match);
    }
}
