package com.dona.tarealabo5.dao;

import java.util.List;

import com.dona.tarealabo5.domain.Student;

import org.springframework.dao.DataAccessException;

public interface StudentDAO {
    public List<Student> findAll() throws DataAccessException;

    public void save(Student e) throws DataAccessException;
}