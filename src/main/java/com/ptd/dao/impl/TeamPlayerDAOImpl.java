package com.ptd.dao.impl;

import com.ptd.dao.TeamPlayerDAO;
import com.ptd.entity.Team;
import com.ptd.entity.TeamPlayer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeamPlayerDAOImpl implements TeamPlayerDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addTeamPlayer(TeamPlayer teamPlayer) {
        entityManager.persist(teamPlayer);
    }

    @Override
    public List<TeamPlayer> getPlayerByUser(int userId) {
        String jql = "select e from TeamPlayer e where e.user.id = " + userId;
        return entityManager.createQuery(jql, TeamPlayer.class).getResultList();
    }

    @Override
    public List<TeamPlayer> getPlayerByTeam(int teamId) {
        String jql = "select e from TeamPlayer e where e.team.id =" + teamId;
        return entityManager.createQuery(jql, TeamPlayer.class).getResultList();
    }


}
