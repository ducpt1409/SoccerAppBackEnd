package com.ptd.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`match`")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "match_name")
    private String match_name;

    @ManyToOne
    @JoinColumn(name = "team_create")
    private Team team;

    @Column(name = "team_join")
    private int team_join;

    @Column(name = "location")
    private String location;

    @Column(name = "time")
    private String time;

    @Column(name = "status")
    private int status;

    @Column(name = "note")
    private String note;

    @OneToOne(mappedBy = "match", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ScoreBoard scoreBoard;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchInvitation> matchInvitations;

    public Match() {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTeam_join() {
        return team_join;
    }

    public void setTeam_join(int team_join) {
        this.team_join = team_join;
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

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public List<MatchInvitation> getMatchInvitations() {
        return matchInvitations;
    }

    public void setMatchInvitations(List<MatchInvitation> matchInvitations) {
        this.matchInvitations = matchInvitations;
    }
}
