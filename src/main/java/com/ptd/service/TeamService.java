package com.ptd.service;

import com.ptd.model.TeamDTO;

import java.util.List;

public interface TeamService {
    public void addTeam(TeamDTO teamDTO, String position, int userId);
    public List<TeamDTO> getTeamByUser(int userId);
    public TeamDTO getTeamById(int id);
    public void updateTeam(TeamDTO teamDTO, String wardId);
    public List<TeamDTO> getTeamByName(String name);
}
