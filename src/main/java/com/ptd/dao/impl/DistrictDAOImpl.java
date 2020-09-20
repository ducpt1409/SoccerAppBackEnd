package com.ptd.dao.impl;

import com.ptd.dao.DistrictDAO;
import com.ptd.entity.District;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DistrictDAOImpl implements DistrictDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<District> getDistrictByProvince(String id) {
        String jql = "select e from District e where e.province.id = '" + id + "'";
        return entityManager.createQuery(jql, District.class).getResultList();
    }
}
