package com.ptd.dao;

import com.ptd.entity.District;

import java.util.List;

public interface DistrictDAO {
    public List<District> getDistrictByProvince(String id);
}
