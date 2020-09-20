package com.ptd.dao.impl;

import com.ptd.dao.TeamDAO;
import com.ptd.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeamDAOImpl implements TeamDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addNewTeam(Team team) {
        entityManager.persist(team);
    }

    @Override
    public Team getTeamById(int id) {
        return entityManager.find(Team.class,id);
    }

    @Override
    public void updateTeam(Team team) {
        entityManager.merge(team);
    }

    @Override
    public List<Team> getTeamByName(String name) {
        String jql = "select e from Team e where e.name like '%"+name+"%'";
        return entityManager.createQuery(jql, Team.class).getResultList();
    }
}
