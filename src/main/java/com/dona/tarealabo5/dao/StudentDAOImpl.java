package com.dona.tarealabo5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dona.tarealabo5.domain.Student;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext(unitName = "tarealabo5")
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.estudiante");
        Query query = entityManager.createNativeQuery(sb.toString(), Student.class);
        List<Student> res = query.getResultList();

        return res;
    }

    @Override
    @Transactional
    public void save(Student e) throws DataAccessException {
        entityManager.persist(e);
    }
    
}