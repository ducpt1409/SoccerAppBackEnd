package com.ptd.model;

public class TeamLocationDTO {
    private int id;
    private WardDTO wardDTO;

    public TeamLocationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WardDTO getWardDTO() {
        return wardDTO;
    }

    public void setWardDTO(WardDTO wardDTO) {
        this.wardDTO = wardDTO;
    }

    @Override
    public String toString() {
        return "TeamLocationDTO{" +
                "id=" + id +
                ", wardDTO=" + wardDTO +
                '}';
    }
}
