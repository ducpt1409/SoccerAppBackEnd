package com.ptd.entity;

import javax.persistence.*;

@Entity
@Table(name = "`matchinvitation`")
public class MatchInvitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "team_invite")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Column(name = "type")
    private int type;

    @Column(name = "status")
    private int status;

    @Column(name = "time")
    private String time;

    @Column(name = "note")
    private String note;

    public MatchInvitation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
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
}
