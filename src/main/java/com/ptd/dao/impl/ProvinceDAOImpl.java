package com.ptd.dao.impl;

import com.ptd.dao.ProvinceDAO;
import com.ptd.entity.Province;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProvinceDAOImpl implements ProvinceDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Province> getAllProvince() {
        String jql = "select e from Province e";
        return entityManager.createQuery(jql, Province.class).getResultList();
    }
}
