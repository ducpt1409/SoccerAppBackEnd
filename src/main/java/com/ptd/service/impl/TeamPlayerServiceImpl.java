package com.ptd.service.impl;

import com.ptd.dao.TeamDAO;
import com.ptd.dao.TeamPlayerDAO;
import com.ptd.dao.UserDAO;
import com.ptd.entity.Team;
import com.ptd.entity.TeamPlayer;
import com.ptd.entity.User;
import com.ptd.model.TeamPlayerDTO;
import com.ptd.model.UserDTO;
import com.ptd.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamPlayerServiceImpl implements TeamPlayerService {

    @Autowired
    TeamPlayerDAO teamPlayerDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    TeamDAO teamDAO;


    @Override
    public List<TeamPlayerDTO> getPlayersByTeam(int teamID) {
        List<TeamPlayer> teamPlayers = teamPlayerDAO.getPlayerByTeam(teamID);
        List<TeamPlayerDTO> teamPlayerDTOS = new ArrayList<>();
        for (TeamPlayer i : teamPlayers) {
            TeamPlayerDTO teamPlayerDTO = new TeamPlayerDTO();
            teamPlayerDTO.setId(i.getId());
            teamPlayerDTO.setIsTeamLead(i.getIsteamLead());
            teamPlayerDTO.setPosition(i.getPosition());

            UserDTO userDTO = new UserDTO();
            User user = i.getUser();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setDoB(user.getDoB());
            userDTO.setAvatarUrl(user.getAvatarUrl());
            userDTO.setIntroduce(user.getIntroduce());
            userDTO.setAchievement(user.getAchievement());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setLocation(user.getLocation());

            teamPlayerDTO.setUserDTO(userDTO);
            teamPlayerDTOS.add(teamPlayerDTO);
        }

        return teamPlayerDTOS;
    }

    @Override
    public void addTeamPlayer(int teamId, int userId, String position) {
        User user = userDAO.getUserById(userId);
        Team team = teamDAO.getTeamById(teamId);
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setTeam(team);
        teamPlayer.setUser(user);
        teamPlayer.setIsteamLead(0);
        teamPlayer.setPosition(position);

        teamPlayerDAO.addTeamPlayer(teamPlayer);

    }
}
