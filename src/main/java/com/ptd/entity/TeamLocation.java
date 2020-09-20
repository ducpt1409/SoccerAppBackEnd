package com.ptd.entity;

import javax.persistence.*;

@Entity
@Table(name = "teamlocation")
public class TeamLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @OneToOne(mappedBy = "teamLocation")
    Team team;

    public TeamLocation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "TeamLocation{" +
                "id=" + id +
                ", ward=" + ward +
                ", team=" + team +
                '}';
    }
}
