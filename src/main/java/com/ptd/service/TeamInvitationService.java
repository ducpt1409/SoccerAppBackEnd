package com.ptd.service;

import com.ptd.model.TeamInvitationDTO;

import java.util.List;

public interface TeamInvitationService {
    public void addNewTeamInvitation(TeamInvitationDTO teamInvitationDTO);

    public List<TeamInvitationDTO> getTeamInvitationByTeamWaiting(int userId);

    public List<TeamInvitationDTO> getTeamInvitationByTeamSented(int teamId);

    public List<TeamInvitationDTO> getTeamInvitationByUser(int userId);

    public List<TeamInvitationDTO> getTeamInvitationByUserWaiting(int teamId);

    public void approveTeamInvitation(int invitationId);

    public void refuseTeamInvitation(int invitationId);

    public void deleteTeamInvitation(int invitationId);
}
