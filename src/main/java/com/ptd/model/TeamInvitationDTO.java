package com.ptd.model;

public class TeamInvitationDTO {
    private int id;
    private String date_time;
    private String position;
    private int type;
    private int status;
    private String note;
    private UserDTO user_invite;
    private UserDTO invite_by;
    private TeamDTO teamDTO;

    public TeamInvitationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public UserDTO getUser_invite() {
        return user_invite;
    }

    public void setUser_invite(UserDTO user_invite) {
        this.user_invite = user_invite;
    }

    public UserDTO getInvite_by() {
        return invite_by;
    }

    public void setInvite_by(UserDTO invite_by) {
        this.invite_by = invite_by;
    }

    public TeamDTO getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }
}
