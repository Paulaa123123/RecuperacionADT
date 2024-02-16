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

/**
 *
 * @author 2dam
 */
public interface SubjectInterface {

    public void deleteSubject(Subject sub) throws DeleteException;

    public void createSubject(Subject sub) throws CreateException;

    public void updateSubject(Subject sub) throws UpdateException;
}
