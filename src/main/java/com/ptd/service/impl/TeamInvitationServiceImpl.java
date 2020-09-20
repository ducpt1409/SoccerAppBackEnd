package com.ptd.service.impl;

import com.ptd.dao.TeamDAO;
import com.ptd.dao.TeamInvitationDAO;
import com.ptd.dao.UserDAO;
import com.ptd.entity.Team;
import com.ptd.entity.TeamInvitation;
import com.ptd.entity.User;
import com.ptd.model.TeamDTO;
import com.ptd.model.TeamInvitationDTO;
import com.ptd.model.UserDTO;
import com.ptd.service.TeamInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamInvitationServiceImpl implements TeamInvitationService {
    @Autowired
    TeamInvitationDAO teamInvitationDAO;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    UserDAO userDAO;

    public List<TeamInvitationDTO> toDTO(List<TeamInvitation> teamInvitations) {
        List<TeamInvitationDTO> teamInvitationDTOS = new ArrayList<>();
        for (TeamInvitation i : teamInvitations) {
            TeamInvitationDTO teamInvitationDTO = new TeamInvitationDTO();
            teamInvitationDTO.setId(i.getId());
            teamInvitationDTO.setDate_time(i.getDate_time());
            teamInvitationDTO.setNote(i.getNote());
            teamInvitationDTO.setPosition(i.getPosition());
            teamInvitationDTO.setStatus(i.getStatus());
            teamInvitationDTO.setType(i.getType());

            UserDTO userInvite = new UserDTO();
            userInvite.setId(i.getUser_invite().getId());
            userInvite.setName(i.getUser_invite().getName());
            userInvite.setAvatarUrl(i.getUser_invite().getAvatarUrl());
            teamInvitationDTO.setUser_invite(userInvite);

            UserDTO userDTOInviteBy = new UserDTO();
            userDTOInviteBy.setId(i.getInvited_by().getId());
            userDTOInviteBy.setName(i.getInvited_by().getName());
            userDTOInviteBy.setAvatarUrl(i.getInvited_by().getAvatarUrl());

            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(i.getTeam().getId());
            teamDTO.setName(i.getTeam().getName());
            teamDTO.setAvatarUrl(i.getTeam().getAvatarUrl());

            teamInvitationDTO.setInvite_by(userDTOInviteBy);
            teamInvitationDTO.setTeamDTO(teamDTO);

            teamInvitationDTOS.add(teamInvitationDTO);
        }

        return teamInvitationDTOS;
    }

    @Override
    public void addNewTeamInvitation(TeamInvitationDTO teamInvitationDTO) {
        TeamInvitation teamInvitation = new TeamInvitation();
        Team team = teamDAO.getTeamById(teamInvitationDTO.getTeamDTO().getId());
        User userinvite = userDAO.getUserById(teamInvitationDTO.getUser_invite().getId());
        User invitedBy = userDAO.getUserById(teamInvitationDTO.getInvite_by().getId());

        teamInvitation.setDate_time(teamInvitationDTO.getDate_time());
        teamInvitation.setNote(teamInvitationDTO.getNote());
        teamInvitation.setPosition(teamInvitationDTO.getPosition());
        teamInvitation.setType(teamInvitationDTO.getType());
        teamInvitation.setStatus(1);
        teamInvitation.setType(1);
        teamInvitation.setInvited_by(invitedBy);
        teamInvitation.setUser_invite(userinvite);
        teamInvitation.setTeam(team);

        teamInvitationDAO.addNewTeamInvitation(teamInvitation);
    }

    @Override
    public List<TeamInvitationDTO> getTeamInvitationByTeamWaiting(int userId) {
        List<TeamInvitation> teamInvitations = teamInvitationDAO.getTeamInvitationByTeamWaiting(userId);
        List<TeamInvitationDTO> teamInvitationDTOS = toDTO(teamInvitations);
        return teamInvitationDTOS;
    }

    @Override
    public List<TeamInvitationDTO> getTeamInvitationByTeamSented(int teamId) {
        List<TeamInvitation> teamInvitations = teamInvitationDAO.getTeamInvitationByTeamInvited(teamId);
        List<TeamInvitationDTO> teamInvitationDTOS = toDTO(teamInvitations);
        return teamInvitationDTOS;
    }

    @Override
    public List<TeamInvitationDTO> getTeamInvitationByUser(int userId) {
        List<TeamInvitation> teamInvitations = teamInvitationDAO.getTeamInvitationByUser(userId);
        List<TeamInvitationDTO> teamInvitationDTOS = toDTO(teamInvitations);
        return teamInvitationDTOS;
    }

    @Override
    public List<TeamInvitationDTO> getTeamInvitationByUserWaiting(int teamId) {
        List<TeamInvitation> teamInvitations = teamInvitationDAO.getTeamInvitationByUserWaiting(teamId);
        List<TeamInvitationDTO> teamInvitationDTOS = toDTO(teamInvitations);
        return teamInvitationDTOS;
    }

    @Override
    public void approveTeamInvitation(int invitationId) {
        teamInvitationDAO.approveInvitation(invitationId);
    }

    @Override
    public void refuseTeamInvitation(int invitationId) {
        teamInvitationDAO.refuseInvitation(invitationId);
    }

    @Override
    public void deleteTeamInvitation(int invitationId) {
        teamInvitationDAO.deleteInvitation(invitationId);
    }


}
