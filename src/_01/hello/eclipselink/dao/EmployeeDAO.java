/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _01.hello.eclipselink.dao;

import _01.hello.eclipselink.model.Employee;
import java.util.List;

/**
 *
 * @author unver
 */
public interface EmployeeDAO {
    //Ekleme işlemi yapacağımız method
    public Employee insertEmployee(int id,String name,String surname,int salary);
    
    //Listelemek için method
    public List<Employee> listEmployee();
    
    //Bulmak için kullandığımız method
    public Employee findEmployee(int id);
    
    //Silmek için kullandığımız method
    public void removeEmployee(int id);
    
    //Maaşa zam yapmak için kullandığımız method
    public Employee raiseSalary(int id,int salary);
    
}
