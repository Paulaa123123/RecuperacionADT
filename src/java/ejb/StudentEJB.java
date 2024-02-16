/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Student;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.UpdateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 2dam
 */
@Stateless
public class StudentEJB implements StudentInterface {

    @PersistenceContext(unitName = "ExamenADTPU")
    private EntityManager em;

    @Override
    public void deleteStudent(Student stu) throws DeleteException {
        try {
            ;
            em.remove(em.merge(stu));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void createStudent(Student stu) throws CreateException {
        try {
            em.persist(stu);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateStudent(Student stu) throws UpdateException {
        try {
            if (!em.contains(stu)) {
                em.merge(stu);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

}
