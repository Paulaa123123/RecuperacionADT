/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.School;
import entidades.Student;
import entidades.Subject;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 2dam
 */
@Stateless
public class SchoolEJB implements SchoolInterface {

    @PersistenceContext(unitName = "ExamenADTPU")
    private EntityManager em;

    @Override
    public void deleteSchool(School sch) throws DeleteException {
        try {
            em.remove(em.merge(sch));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void createSchool(School sch) throws CreateException {
        try {
            em.persist(sch);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateSchool(School sch) throws UpdateException {
        try {
            if (!em.contains(sch)) {
                em.merge(sch);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public List<Student> findStudents() throws ReadException {
        List<Student> studentList;
        try {
            studentList = em.createNamedQuery("student").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return studentList;
    }

    @Override
    public List<Subject> findSubjects() throws ReadException {
        List<Subject> subjectList;
        try {
            subjectList = em.createNamedQuery("subject").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return subjectList;
    }

}
