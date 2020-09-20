package com.ptd.model;

public class ScoreBoardDTO {
    private int id;
    private String finalScore;
    private int totalMinute;
    private String penaltyScore;
    private String note;
    private MatchDTO matchDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public MatchDTO getMatchDTO() {
        return matchDTO;
    }

    public void setMatchDTO(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }
}
