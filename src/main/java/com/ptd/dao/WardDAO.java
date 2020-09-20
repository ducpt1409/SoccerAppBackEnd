package com.ptd.dao;

import com.ptd.entity.Ward;

import java.util.List;

public interface WardDAO {
    public List<Ward> getWardByDistrict(String id);
    public Ward getWardById(String id);
}
