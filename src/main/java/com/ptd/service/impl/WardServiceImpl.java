package com.ptd.service.impl;

import com.ptd.dao.WardDAO;
import com.ptd.entity.District;
import com.ptd.entity.Province;
import com.ptd.entity.Ward;
import com.ptd.model.DistrictDTO;
import com.ptd.model.ProvinceDTO;
import com.ptd.model.WardDTO;
import com.ptd.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    WardDAO wardDAO;

    @Override
    public List<WardDTO> getWardByDistrict(String districtId) {
        List<Ward> wards = wardDAO.getWardByDistrict(districtId);
        List<WardDTO> wardDTOS = new ArrayList<>();
        for (Ward i : wards) {
            WardDTO wardDTO = new WardDTO();
            wardDTO.setId(i.getId());
            wardDTO.setName(i.getName());
            wardDTO.setType(i.getType());
            wardDTOS.add(wardDTO);
        }
        return wardDTOS;
    }

    @Override
    public WardDTO getWardById(String wardId) {
        Ward ward = wardDAO.getWardById(wardId);
        District district = ward.getDistrict();
        Province province = district.getProvince();

        WardDTO wardDTO = new WardDTO();
        DistrictDTO districtDTO = new DistrictDTO();
        ProvinceDTO provinceDTO = new ProvinceDTO();

        provinceDTO.setId(province.getId());
        provinceDTO.setName(province.getName());
        provinceDTO.setType(province.getType());

        districtDTO.setId(district.getId());
        districtDTO.setName(district.getName());
        districtDTO.setType(district.getType());
        districtDTO.setProvince(provinceDTO);

        wardDTO.setId(wardId);
        wardDTO.setName(ward.getName());
        wardDTO.setType(ward.getType());
        wardDTO.setDistrictDTO(districtDTO);

        return wardDTO;

    }

}
