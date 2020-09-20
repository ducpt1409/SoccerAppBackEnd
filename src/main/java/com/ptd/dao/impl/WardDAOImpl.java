package com.ptd.dao.impl;

import com.ptd.dao.WardDAO;
import com.ptd.entity.Ward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class WardDAOImpl implements WardDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Ward> getWardByDistrict(String id) {
        String jql = "select e from Ward e where e.district.id = '" + id + "'";
        return entityManager.createQuery(jql, Ward.class).getResultList();
    }

    @Override
    public Ward getWardById(String id) {
        return entityManager.find(Ward.class,id);
    }
}
