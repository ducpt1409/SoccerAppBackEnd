package com.ptd.dao.impl;

import com.ptd.dao.MatchInvitationDAO;
import com.ptd.entity.MatchInvitation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MatchInvitationDAOImpl implements MatchInvitationDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void makeInvitation(MatchInvitation matchInvitation) {
        entityManager.persist(matchInvitation);
    }

    @Override
    public List<MatchInvitation> getSentMatchInvitation(int matchId) {
        String jql = "select e from MatchInvitation e where e.type = 1 and e.match.id = " + matchId;
        return entityManager.createQuery(jql, MatchInvitation.class).getResultList();
    }

    @Override
    public List<MatchInvitation> getReceivedMatchInvitation(int matchId) {
        String jql = "select e from MatchInvitation e where e.type = 2 and e.status!=0 and e.match.id = " + matchId;
        return entityManager.createQuery(jql, MatchInvitation.class).getResultList();
    }

    @Override
    public List<MatchInvitation> getWaitingInvitationByTeam(int teamId) {
        String jql = "select e from MatchInvitation e where e.type = 1 and e.status = 1 and e.team = " + teamId;
        return entityManager.createQuery(jql, MatchInvitation.class).getResultList();
    }

    @Override
    public void updateStatusMatchInvitation(int matchInvitationId, int status) {
        String jql = "update MatchInvitation e set e.status = " + status + " where e.id = " + matchInvitationId;
        entityManager.createQuery(jql).executeUpdate();
    }

    @Override
    public void deleteMatchInvitation(int matchId) {
        MatchInvitation matchInvitation = entityManager.find(MatchInvitation.class, matchId);
        entityManager.remove((matchInvitation));
    }

}
