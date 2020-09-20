package com.ptd.dao.impl;

import com.ptd.dao.TeamInvitationDAO;
import com.ptd.entity.TeamInvitation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeamInvitationDAOImpl implements TeamInvitationDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addNewTeamInvitation(TeamInvitation teamInvitation) {
        entityManager.persist(teamInvitation);
    }

    @Override
    public List<TeamInvitation> getTeamInvitationByTeamWaiting(int userId) {
        String jql = "select e from TeamInvitation e where e.type = 1 and e.status = 1 and e.user_invite = " + userId;
        return entityManager.createQuery(jql, TeamInvitation.class).getResultList();
    }

    @Override
    public List<TeamInvitation> getTeamInvitationByUser(int userId) {
        String jql = "select e from TeamInvitation e where e.type = 2 and e.user_invite.id = " + userId;
        return entityManager.createQuery(jql, TeamInvitation.class).getResultList();
    }


    @Override
    public List<TeamInvitation> getTeamInvitationByUserWaiting(int teamId) {
        String jql = "select e from TeamInvitation e where e.type = 2 and e.team.id = " + teamId;
        return entityManager.createQuery(jql, TeamInvitation.class).getResultList();
    }

    @Override
    public List<TeamInvitation> getTeamInvitationByTeamInvited(int teamId) {
        String jql = "select e from TeamInvitation e where e.type = 1 and e.team.id = " + teamId;
        return entityManager.createQuery(jql, TeamInvitation.class).getResultList();
    }

    @Override
    public void approveInvitation(int invitationId) {
        String jql = "update TeamInvitation e set e.status = 2 where e.id = " + invitationId;
        entityManager.createQuery(jql).executeUpdate();
    }

    @Override
    public void refuseInvitation(int invitationId) {
        String jql = "update TeamInvitation e set e.status = 0 where e.id = " + invitationId;
        entityManager.createQuery(jql).executeUpdate();
    }

    @Override
    public void deleteInvitation(int invitationId) {
        String jql = "delete from TeamInvitation e where e.id = " + invitationId;
        entityManager.createQuery(jql).executeUpdate();
    }


}
