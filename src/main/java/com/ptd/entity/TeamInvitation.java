package com.ptd.entity;

import javax.persistence.*;

@Entity
@Table(name = "teaminvitation")
public class TeamInvitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_time")
    private String date_time;

    @Column(name = "position")
    private String position;

    @Column(name = "type")
    private int type;

    @Column(name = "status")
    private int status;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_invite;

    @ManyToOne
    @JoinColumn(name = "invited_by")
    private User invited_by;

    public TeamInvitation() {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getUser_invite() {
        return user_invite;
    }

    public void setUser_invite(User user_invite) {
        this.user_invite = user_invite;
    }

    public User getInvited_by() {
        return invited_by;
    }

    public void setInvited_by(User invited_by) {
        this.invited_by = invited_by;
    }
}
