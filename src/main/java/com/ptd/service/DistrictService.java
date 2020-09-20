package com.ptd.service;

import com.ptd.model.DistrictDTO;

import java.util.List;

public interface DistrictService {
    public List<DistrictDTO> getDistrictByProvince(String districtId);
}
