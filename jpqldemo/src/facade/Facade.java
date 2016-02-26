/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Student;
import entity.Studypoint;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Magnus
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    public List<Student> findAllStudents() {

        TypedQuery<Student> tq = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> list = tq.getResultList();
        return list;
    }

    public List<Student> findAllStudentJan() {

        TypedQuery<Student> tq = em.createQuery("SELECT s from Student s where s.firstname = :name", Student.class);
        tq.setParameter("name", "jan");
        List<Student> list = tq.getResultList();
        return list;
    }

    public List<Student> findAllStudentOlsen() {

        TypedQuery<Student> tq = em.createQuery("SELECT s from Student s where s.lastname = :name", Student.class);
        tq.setParameter("name", "olsen");
        List<Student> list = tq.getResultList();
        return list;
    }

    public Long studyPointSumStudent(int id) {
        TypedQuery tq = em.createQuery("SELECT SUM(s.score) from Studypoint s where s.student.id = :id", Studypoint.class);
        tq.setParameter("id", id);
        Long test = (Long) tq.getSingleResult();
        return test;
    }

    public Long studyPointSumAll() {
        TypedQuery tq = em.createQuery("SELECT SUM(s.score) from Studypoint s", Studypoint.class);
        Long test = (Long) tq.getSingleResult();
        return test;
    }

    public Student findStudentMaxScore() {
        TypedQuery<Student> tq = em.createQuery("SELECT s from Student s join s.studypointCollection p ORDER BY p.score DESC", Student.class);
        tq.setFirstResult(0);
        tq.setMaxResults(1);
        Student s = tq.getSingleResult();
        return s;
    }
    
        public Student findStudentMinScore() {
        TypedQuery<Student> tq = em.createQuery("SELECT s from Student s join s.studypointCollection p ORDER BY p.score", Student.class);
        tq.setFirstResult(0);
        tq.setMaxResults(1);
        Student s = tq.getSingleResult();
        return s;
    }
        
        
    
}
