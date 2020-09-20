package com.ptd.model;

public class TeamPlayerDTO {
    private int id;
    private String position;
    private int isTeamLead;
    private UserDTO userDTO;
    private TeamDTO teamDTO;

    public TeamPlayerDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getIsTeamLead() {
        return isTeamLead;
    }

    public void setIsTeamLead(int isTeamLead) {
        this.isTeamLead = isTeamLead;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public TeamDTO getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }
}
