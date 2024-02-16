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

/**
 *
 * @author 2dam
 */
public interface StudentInterface {

    public void deleteStudent(Student stu) throws DeleteException;

    public void createStudent(Student stu) throws CreateException;

    public void updateStudent(Student stu) throws UpdateException;
}
