package com.ptd.service.impl;

import com.ptd.dao.ProvinceDAO;
import com.ptd.entity.Province;
import com.ptd.model.ProvinceDTO;
import com.ptd.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDAO provinceDAO;

    @Override
    public List<ProvinceDTO> getAllProvince() {
        List<Province> provinces = provinceDAO.getAllProvince();
        List<ProvinceDTO> provinceDTOS = new ArrayList<>();
        for (Province i : provinces) {
            ProvinceDTO provinceDTO = new ProvinceDTO();
            provinceDTO.setId(i.getId());
            provinceDTO.setName(i.getName());
            provinceDTO.setType(i.getType());

            provinceDTOS.add(provinceDTO);
        }
        return provinceDTOS;
    }
}
