package com.ptd.service.impl;

import com.ptd.dao.TeamDAO;
import com.ptd.dao.TeamPlayerDAO;
import com.ptd.dao.UserDAO;
import com.ptd.dao.WardDAO;
import com.ptd.entity.*;
import com.ptd.model.*;
import com.ptd.service.TeamService;
import com.ptd.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamDAO teamDAO;
    @Autowired
    WardDAO wardDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    TeamPlayerDAO teamPlayerDAO;
    @Autowired
    WardService wardService;


    @Override
    public void addTeam(TeamDTO teamDTO, String postion, int userId) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setAvatarUrl(teamDTO.getAvatarUrl());
        team.setDescription(teamDTO.getDescription());

        Ward ward = wardDAO.getWardById(teamDTO.getTeamLocationDTO().getWardDTO().getId());
        TeamLocation teamLocation = new TeamLocation();
        teamLocation.setWard(ward);

        team.setTeamLocation(teamLocation);

        List<TeamPlayer> teamPlayerList = new ArrayList<>();
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setPosition(postion);
        teamPlayer.setIsteamLead(1);
        User user = userDAO.getUserById(userId);
        teamPlayer.setUser(user);
        teamPlayerList.add(teamPlayer);

        team.setTeamPlayers(teamPlayerList);

        teamLocation.setTeam(team);
        team.setTeamLocation(teamLocation);
        for (TeamPlayer i : teamPlayerList) i.setTeam(team);
        team.setTeamPlayers(teamPlayerList);

        teamDAO.addNewTeam(team);

    }

    @Override
    public List<TeamDTO> getTeamByUser(int userId) {
        List<TeamPlayer> teamPlayers = teamPlayerDAO.getPlayerByUser(userId);
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for (TeamPlayer i : teamPlayers) {
            Team team = i.getTeam();
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(team.getId());
            teamDTO.setName(team.getName());
            teamDTO.setAvatarUrl(team.getAvatarUrl());
            teamDTO.setDescription(team.getDescription());
            teamDTO.setAchievement(team.getAchievement());

            TeamLocation teamLocation = team.getTeamLocation();
            String wardId = teamLocation.getWard().getId();

            WardDTO wardDTO = wardService.getWardById(wardId);

            TeamLocationDTO teamLocationDTO = new TeamLocationDTO();
            teamLocationDTO.setId(teamLocation.getId());
            teamLocationDTO.setWardDTO(wardDTO);

            teamDTO.setTeamLocationDTO(teamLocationDTO);

            teamDTOS.add(teamDTO);
        }
        return teamDTOS;
    }

    @Override
    public TeamDTO getTeamById(int id) {
        Team team = teamDAO.getTeamById(id);
        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setAvatarUrl(team.getAvatarUrl());
        teamDTO.setDescription(team.getDescription());
        teamDTO.setAchievement(team.getAchievement());

        TeamLocation teamLocation = team.getTeamLocation();
        String wardId = teamLocation.getWard().getId();

        WardDTO wardDTO = wardService.getWardById(wardId);

        TeamLocationDTO teamLocationDTO = new TeamLocationDTO();
        teamLocationDTO.setId(teamLocation.getId());
        teamLocationDTO.setWardDTO(wardDTO);

        teamDTO.setTeamLocationDTO(teamLocationDTO);

        return teamDTO;
    }

    @Override
    public void updateTeam(TeamDTO teamDTO, String wardId) {
        Team team = teamDAO.getTeamById(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setAvatarUrl(teamDTO.getAvatarUrl());
        team.setDescription(teamDTO.getDescription());

        Ward ward = wardDAO.getWardById(wardId);
        TeamLocation teamLocation = team.getTeamLocation();
        teamLocation.setWard(ward);

        team.setTeamLocation(teamLocation);

        teamDAO.updateTeam(team);
    }

    @Override
    public List<TeamDTO> getTeamByName(String name) {
        List<Team> teams = teamDAO.getTeamByName(name);
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for (Team i : teams) {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(i.getId());
            teamDTO.setName(i.getName());
            teamDTO.setAvatarUrl(i.getAvatarUrl());
            teamDTO.setDescription(i.getDescription());
            teamDTO.setAchievement(i.getAchievement());

            TeamLocation teamLocation = i.getTeamLocation();
            String wardId = teamLocation.getWard().getId();

            WardDTO wardDTO = wardService.getWardById(wardId);

            TeamLocationDTO teamLocationDTO = new TeamLocationDTO();
            teamLocationDTO.setId(teamLocation.getId());
            teamLocationDTO.setWardDTO(wardDTO);

            teamDTO.setTeamLocationDTO(teamLocationDTO);

            teamDTOS.add(teamDTO);
        }
        return teamDTOS;
    }


}
