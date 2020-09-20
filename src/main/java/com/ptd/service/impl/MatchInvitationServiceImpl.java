package com.ptd.service.impl;

import com.ptd.dao.MatchDAO;
import com.ptd.dao.MatchInvitationDAO;
import com.ptd.dao.TeamDAO;
import com.ptd.entity.Match;
import com.ptd.entity.MatchInvitation;
import com.ptd.entity.Team;
import com.ptd.model.MatchDTO;
import com.ptd.model.MatchInvitationDTO;
import com.ptd.service.MatchInvitationService;
import com.ptd.service.MatchService;
import com.ptd.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchInvitationServiceImpl implements MatchInvitationService {
    @Autowired
    MatchInvitationDAO matchInvitationDAO;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    MatchDAO matchDAO;

    @Autowired
    MatchService matchService;

    @Autowired
    TeamService teamService;

    public List<MatchInvitationDTO> toDTO(List<MatchInvitation> matchInvitations) {
        List<MatchInvitationDTO> matchInvitationDTOS = new ArrayList<>();
        for (MatchInvitation i : matchInvitations) {
            MatchInvitationDTO matchInvitationDTO = new MatchInvitationDTO();
            matchInvitationDTO.setId(i.getId());
            matchInvitationDTO.setType(i.getType());
            matchInvitationDTO.setTime(i.getTime());
            matchInvitationDTO.setNote(i.getNote());
            matchInvitationDTO.setStatus(i.getStatus());

            MatchDTO matchDTO = matchService.getMatchById(i.getMatch().getId());
            matchInvitationDTO.setMatchDTO(matchDTO);

            matchInvitationDTO.setTeamInvite(teamService.getTeamById(i.getTeam().getId()));

            matchInvitationDTOS.add(matchInvitationDTO);
        }
        return matchInvitationDTOS;
    }

    @Override
    public void makeInvitation(MatchInvitationDTO matchInvitationDTO) {
        MatchInvitation matchInvitation = new MatchInvitation();
        matchInvitation.setNote(matchInvitationDTO.getNote());
        matchInvitation.setStatus(1);
        matchInvitation.setTime(matchInvitationDTO.getTime());
        matchInvitation.setType(matchInvitationDTO.getType());
        Team team = teamDAO.getTeamById(matchInvitationDTO.getTeamInvite().getId());
        Match match = matchDAO.getMatchById(matchInvitationDTO.getMatchDTO().getId());

        matchInvitation.setTeam(team);
        matchInvitation.setMatch(match);

        matchInvitationDAO.makeInvitation(matchInvitation);
    }

    @Override
    public List<MatchInvitationDTO> getSentMatchInvitation(int matchId) {
        List<MatchInvitation> matchInvitations = matchInvitationDAO.getSentMatchInvitation(matchId);

        List<MatchInvitationDTO> matchInvitationDTOS = toDTO(matchInvitations);
        return matchInvitationDTOS;
    }

    @Override
    public List<MatchInvitationDTO> getReceivedMatchInvitation(int matchId) {
        List<MatchInvitation> matchInvitations = matchInvitationDAO.getReceivedMatchInvitation(matchId);

        List<MatchInvitationDTO> matchInvitationDTOS = toDTO(matchInvitations);
        return matchInvitationDTOS;
    }

    @Override
    public List<MatchInvitationDTO> getWaitingMatchInvitation(int teamId) {
        List<MatchInvitation> matchInvitations = matchInvitationDAO.getWaitingInvitationByTeam(teamId);

        List<MatchInvitationDTO> matchInvitationDTOS = toDTO(matchInvitations);
        return matchInvitationDTOS;
    }

    @Override
    public void updateStatusInvitation(int matchId, int status) {
        matchInvitationDAO.updateStatusMatchInvitation(matchId, status);
    }

    @Override
    public void deleteInvitation(int matchId) {
        matchInvitationDAO.deleteMatchInvitation(matchId);
    }
}
