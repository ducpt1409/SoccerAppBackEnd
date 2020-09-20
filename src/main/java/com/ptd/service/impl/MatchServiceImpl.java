package com.ptd.service.impl;

import com.ptd.dao.MatchDAO;
import com.ptd.dao.TeamDAO;
import com.ptd.entity.Match;
import com.ptd.entity.ScoreBoard;
import com.ptd.entity.Team;
import com.ptd.model.MatchDTO;
import com.ptd.model.TeamDTO;
import com.ptd.service.MatchService;
import com.ptd.service.ScoreBoardService;
import com.ptd.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchDAO matchDAO;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    TeamService teamSerivce;

    @Autowired
    ScoreBoardService scoreBoardService;

    @Override
    public void matchMaking(MatchDTO matchDTO, int teamId) {
        Match match = new Match();

        match.setMatch_name(matchDTO.getMatch_name());
        match.setTeam_join(0);
        match.setLocation(matchDTO.getLocation());
        match.setNote(matchDTO.getNote());
        match.setStatus(1);
        match.setTime(matchDTO.getTime());

        Team team = teamDAO.getTeamById(teamId);

        match.setTeam(team);

        matchDAO.matchMaking(match);
    }

    @Override
    public List<MatchDTO> getCreatedMatch(int teamId) {
        List<Match> matches = matchDAO.getCreatedMatch(teamId);
        List<MatchDTO> matchDTOS = new ArrayList<>();
        for (Match i : matches) {
            MatchDTO matchDTO = new MatchDTO();
            matchDTO.setId(i.getId());
            matchDTO.setMatch_name(i.getMatch_name());
            matchDTO.setLocation(i.getLocation());
            matchDTO.setTime(i.getTime());
            matchDTO.setNote(i.getNote());
            matchDTO.setStatus(i.getStatus());
            matchDTO.setTeamCreate(teamSerivce.getTeamById(i.getTeam().getId()));
            if (i.getTeam_join() == 0) {
                matchDTO.setTeamJoin(null);
            } else {
                matchDTO.setTeamJoin(teamSerivce.getTeamById(i.getTeam_join()));
            }
            matchDTO.setScoreBoardDTO(null);
            matchDTO.setMatchInvitationDTOS(null);

            matchDTOS.add(matchDTO);
        }

        return matchDTOS;
    }

    @Override
    public MatchDTO getMatchById(int matchID) {
        Match match = matchDAO.getMatchById(matchID);
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(match.getId());
        matchDTO.setStatus(match.getStatus());
        matchDTO.setNote(match.getNote());
        matchDTO.setTime(match.getTime());
        matchDTO.setLocation(match.getLocation());
        matchDTO.setMatch_name(match.getMatch_name());

        matchDTO.setTeamCreate(teamSerivce.getTeamById(match.getTeam().getId()));

        TeamDTO teamDTO = new TeamDTO();
        if (match.getTeam_join() != 0) {
            teamDTO = teamSerivce.getTeamById(match.getTeam_join());
        }
        matchDTO.setTeamJoin(teamDTO);

        return matchDTO;
    }

    @Override
    public void updateStatusMatch(int matchId, int status) {
        matchDAO.updateStatusMatch(matchId, status);
    }

    @Override
    public void deleteMatch(int matchId) {
        matchDAO.deleteMatch(matchId);
    }

    @Override
    public void addTeamInviteToMatch(int matchId, int teamId) {
        Match match = matchDAO.getMatchById(matchId);
        match.setTeam_join(teamId);
        match.setStatus(2);

        matchDAO.updateMatch(match);
    }
}
