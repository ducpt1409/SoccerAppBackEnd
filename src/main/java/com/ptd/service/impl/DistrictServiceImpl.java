package com.ptd.service.impl;

import com.ptd.dao.DistrictDAO;
import com.ptd.entity.District;
import com.ptd.model.DistrictDTO;
import com.ptd.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictDAO districtDAO;

    @Override
    public List<DistrictDTO> getDistrictByProvince(String districtId) {
        List<District> districts = districtDAO.getDistrictByProvince(districtId);
        List<DistrictDTO> districtDTOS = new ArrayList<>();
        for(District i : districts){
            DistrictDTO districtDTO = new DistrictDTO();
            districtDTO.setId(i.getId());
            districtDTO.setName(i.getName());
            districtDTO.setType(i.getType());

            districtDTOS.add(districtDTO);
        }
        return districtDTOS;
    }
}
