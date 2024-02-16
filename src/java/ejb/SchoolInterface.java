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

/**
 *
 * @author 2dam
 */
public interface SchoolInterface {

    public void deleteSchool(School sch) throws DeleteException;

    public void createSchool(School sch) throws CreateException;

    public void updateSchool(School sch) throws UpdateException;

    public List<Student> findStudents() throws ReadException;

    public List<Subject> findSubjects() throws ReadException;
}
