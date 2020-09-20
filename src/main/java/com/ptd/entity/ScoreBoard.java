package com.ptd.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "`scoreboard`")
public class ScoreBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Column(name = "final_score")
    private String finalScore;

    @Column(name = "total_minute")
    private int totalMinute;

    @Column(name = "penalty_score")
    private String penaltyScore;

    @Column(name = "note")
    private String note;

    public ScoreBoard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public int getTotalMinute() {
        return totalMinute;
    }

    public void setTotalMinute(int totalMinute) {
        this.totalMinute = totalMinute;
    }

    public String getPenaltyScore() {
        return penaltyScore;
    }

    public void setPenaltyScore(String penaltyScore) {
        this.penaltyScore = penaltyScore;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
