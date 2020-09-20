package com.ptd.model;

import com.ptd.entity.Province;
import com.ptd.entity.Ward;

import java.util.List;

public class DistrictDTO {
    private String id;
    private String name;
    private String type;
    private ProvinceDTO province;
    private List<WardDTO> wardDTOSs;

    public DistrictDTO() {
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

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public List<WardDTO> getWardDTOSs() {
        return wardDTOSs;
    }

    public void setWardDTOSs(List<WardDTO> wardDTOSs) {
        this.wardDTOSs = wardDTOSs;
    }

    @Override
    public String toString() {
        return "DistrictDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", province=" + province +
                ", wardDTOSs=" + wardDTOSs +
                '}';
    }
}
