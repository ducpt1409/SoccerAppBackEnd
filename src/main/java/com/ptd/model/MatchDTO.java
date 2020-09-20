package com.ptd.model;

import java.util.List;

public class MatchDTO {
    private int id;
    private String match_name;
    private int status;
    private String location;
    private String time;
    private String note;

    private TeamDTO teamCreate;
    private TeamDTO teamJoin;

    private ScoreBoardDTO scoreBoardDTO;
    private List<MatchInvitationDTO> matchInvitationDTOS;

    public MatchDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TeamDTO getTeamCreate() {
        return teamCreate;
    }

    public void setTeamCreate(TeamDTO teamCreate) {
        this.teamCreate = teamCreate;
    }

    public TeamDTO getTeamJoin() {
        return teamJoin;
    }

    public void setTeamJoin(TeamDTO teamJoin) {
        this.teamJoin = teamJoin;
    }

    public ScoreBoardDTO getScoreBoardDTO() {
        return scoreBoardDTO;
    }

    public void setScoreBoardDTO(ScoreBoardDTO scoreBoardDTO) {
        this.scoreBoardDTO = scoreBoardDTO;
    }

    public List<MatchInvitationDTO> getMatchInvitationDTOS() {
        return matchInvitationDTOS;
    }

    public void setMatchInvitationDTOS(List<MatchInvitationDTO> matchInvitationDTOS) {
        this.matchInvitationDTOS = matchInvitationDTOS;
    }
}
