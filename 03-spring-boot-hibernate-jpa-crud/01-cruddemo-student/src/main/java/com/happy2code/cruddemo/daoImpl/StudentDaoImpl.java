package com.happy2code.cruddemo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happy2code.cruddemo.dao.StudentDao;
import com.happy2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT  s FROM Student s", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findAllStudentsById(String email) {

        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class);

        theQuery.setParameter("email", email);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Student theStudent){
        return entityManager.merge(theStudent);
    }


}
