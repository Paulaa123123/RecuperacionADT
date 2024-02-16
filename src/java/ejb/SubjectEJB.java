/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Subject;
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
public class SubjectEJB implements SubjectInterface {

    @PersistenceContext(unitName = "ExamenADTPU")
    private EntityManager em;

    @Override
    public void deleteSubject(Subject sub) throws DeleteException {
        try {
            em.remove(em.merge(sub));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void createSubject(Subject sub) throws CreateException {
        try {
            em.persist(sub);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateSubject(Subject sub) throws UpdateException {
        try {
            if (!em.contains(sub)) {
                em.merge(sub);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

}
