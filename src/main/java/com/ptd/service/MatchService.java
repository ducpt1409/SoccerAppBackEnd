package com.ptd.service;

import com.ptd.model.MatchDTO;

import java.util.List;

public interface MatchService {
    public void matchMaking(MatchDTO matchDTO, int teamId);
    public List<MatchDTO> getCreatedMatch(int teamId);
    public MatchDTO getMatchById(int matchID);
    public void updateStatusMatch(int matchId, int status);
    public void deleteMatch(int matchId);
    public void addTeamInviteToMatch(int matchId,int teamId);
}
