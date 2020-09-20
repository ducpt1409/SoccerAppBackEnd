package com.ptd.dao;

import com.ptd.entity.TeamPlayer;

import java.util.List;

public interface TeamPlayerDAO {
    public void addTeamPlayer(TeamPlayer teamPlayer);
    public List<TeamPlayer> getPlayerByUser(int userId);
    public List<TeamPlayer> getPlayerByTeam(int teamId);
}
