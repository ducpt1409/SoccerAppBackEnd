package com.ptd.dao;

import com.ptd.entity.MatchInvitation;

import java.util.List;

public interface MatchInvitationDAO {
    public void makeInvitation(MatchInvitation matchInvitation);

    public List<MatchInvitation> getSentMatchInvitation(int matchId);

    public List<MatchInvitation> getReceivedMatchInvitation(int matchId);

    public List<MatchInvitation> getWaitingInvitationByTeam(int teamId);

    public void updateStatusMatchInvitation(int matchId, int status);

    public void deleteMatchInvitation(int matchId);
}
