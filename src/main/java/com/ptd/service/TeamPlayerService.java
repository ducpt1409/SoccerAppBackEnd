package com.ptd.service;

import com.ptd.model.TeamPlayerDTO;

import java.util.List;

public interface TeamPlayerService {
    public List<TeamPlayerDTO> getPlayersByTeam(int teamID);
    public void addTeamPlayer(int teamId, int userId, String position);
}
