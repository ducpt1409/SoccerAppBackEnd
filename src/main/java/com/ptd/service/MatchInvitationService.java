package com.ptd.service;

import com.ptd.entity.MatchInvitation;
import com.ptd.model.MatchInvitationDTO;

import java.util.List;

public interface MatchInvitationService {
    public void makeInvitation(MatchInvitationDTO matchInvitationDTO);

    public List<MatchInvitationDTO> getSentMatchInvitation(int matchId);

    public List<MatchInvitationDTO> getReceivedMatchInvitation(int matchId);

    public List<MatchInvitationDTO> getWaitingMatchInvitation(int teamId);

    public void updateStatusInvitation(int matchId, int status);

    public void deleteInvitation(int matchId);
}
