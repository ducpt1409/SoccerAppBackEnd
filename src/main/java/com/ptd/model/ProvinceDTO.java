package com.ptd.model;

import java.util.List;

public class ProvinceDTO {
    private String id;
    private String name;
    private String type;
    private List<DistrictDTO> districtDTOList;

    public ProvinceDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DistrictDTO> getDistrictDTOList() {
        return districtDTOList;
    }

    public void setDistrictDTOList(List<DistrictDTO> districtDTOList) {
        this.districtDTOList = districtDTOList;
    }

    @Override
    public String toString() {
        return "ProvinceDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", districtDTOList=" + districtDTOList +
                '}';
    }
}
