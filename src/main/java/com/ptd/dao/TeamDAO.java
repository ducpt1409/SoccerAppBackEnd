package com.ptd.dao;

import com.ptd.entity.Team;

import java.util.List;

public interface TeamDAO {
    public void addNewTeam(Team team);
    public Team getTeamById(int id);
    public void updateTeam(Team team);
    public List<Team> getTeamByName(String name);
}
