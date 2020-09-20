package com.ptd.model;

import java.util.List;

public class TeamDTO {
    private int id;
    private String name;
    private String avatarUrl;
    private String description;
    private float achievement;
    private TeamLocationDTO teamLocationDTO;
    private List<TeamPlayerDTO> teamPlayerDTOList;
    private List<TeamInvitationDTO> teamInvitationDTOS;
    private List<MatchDTO> match;
    private List<MatchInvitationDTO> matchInvitationDTOS;

    public List<TeamInvitationDTO> getTeamInvitationDTOS() {
        return teamInvitationDTOS;
    }

    public void setTeamInvitationDTOS(List<TeamInvitationDTO> teamInvitationDTOS) {
        this.teamInvitationDTOS = teamInvitationDTOS;
    }


    public List<MatchInvitationDTO> getMatchInvitationDTOS() {
        return matchInvitationDTOS;
    }

    public void setMatchInvitationDTOS(List<MatchInvitationDTO> matchInvitationDTOS) {
        this.matchInvitationDTOS = matchInvitationDTOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAchievement() {
        return achievement;
    }

    public void setAchievement(float achievement) {
        this.achievement = achievement;
    }

    public TeamLocationDTO getTeamLocationDTO() {
        return teamLocationDTO;
    }

    public void setTeamLocationDTO(TeamLocationDTO teamLocationDTO) {
        this.teamLocationDTO = teamLocationDTO;
    }

    public List<TeamPlayerDTO> getTeamPlayerDTOList() {
        return teamPlayerDTOList;
    }

    public void setTeamPlayerDTOList(List<TeamPlayerDTO> teamPlayerDTOList) {
        this.teamPlayerDTOList = teamPlayerDTOList;
    }

    public TeamDTO() {
    }

    public List<MatchDTO> getMatch() {
        return match;
    }

    public void setMatch(List<MatchDTO> match) {
        this.match = match;
    }
}
