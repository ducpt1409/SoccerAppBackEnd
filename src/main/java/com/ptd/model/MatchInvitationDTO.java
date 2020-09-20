package com.ptd.model;

public class MatchInvitationDTO {
    private int id;
    private int type;
    private int status;
    private String note;
    private String time;
    private MatchDTO matchDTO;
    private TeamDTO teamInvite;

    public MatchInvitationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MatchDTO getMatchDTO() {
        return matchDTO;
    }

    public void setMatchDTO(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }

    public TeamDTO getTeamInvite() {
        return teamInvite;
    }

    public void setTeamInvite(TeamDTO teamInvite) {
        this.teamInvite = teamInvite;
    }
}
