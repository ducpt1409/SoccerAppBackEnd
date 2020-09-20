package com.ptd.dao;

import com.ptd.entity.Match;

import java.util.List;

public interface MatchDAO {
    public void matchMaking(Match match);
    public List<Match> getCreatedMatch(int teamId);
    public Match getMatchById(int id);
    public void updateStatusMatch(int matchId, int status);
    public void deleteMatch(int matchId);
    public void updateMatch(Match match);
}
