package com.ptd.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "achievement")
    private float achievement;

    @JoinColumn(name = "location_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    TeamLocation teamLocation;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamPlayer> teamPlayers;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamInvitation> teamInvitations;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> matches;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchInvitation> matchInvitations;

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

    public TeamLocation getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(TeamLocation teamLocation) {
        this.teamLocation = teamLocation;
    }

    public List<TeamPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<TeamPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public List<TeamInvitation> getTeamInvitations() {
        return teamInvitations;
    }

    public void setTeamInvitations(List<TeamInvitation> teamInvitations) {
        this.teamInvitations = teamInvitations;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<MatchInvitation> getMatchInvitations() {
        return matchInvitations;
    }

    public void setMatchInvitations(List<MatchInvitation> matchInvitations) {
        this.matchInvitations = matchInvitations;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Team() {
    }
}
