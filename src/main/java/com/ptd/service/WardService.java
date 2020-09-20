package com.ptd.service;

import com.ptd.model.WardDTO;

import java.util.List;

public interface WardService {
    public List<WardDTO> getWardByDistrict(String districtId);
    public WardDTO getWardById(String wardId);
}
