/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _01.hello.eclipselink.test;

import _01.hello.eclipselink.dao.EmployeeDAO;
import _01.hello.eclipselink.dao.EmployeeDAOImpl;
import _01.hello.eclipselink.model.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author unver
 */
public class EmployeeTest {
 
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("HelloEclipselinkJPAPU");
        EntityManager em=emf.createEntityManager();

        EmployeeDAO empDao=new EmployeeDAOImpl(em);
        Employee emp1=empDao.insertEmployee(1, "Yunus", "Unver", 1000);
        Employee emp2=empDao.insertEmployee(2, "Ertan", "Akpınaroglu", 1200);
        
        System.out.println("Find:");
        Employee emp3=empDao.findEmployee(1);
        System.out.println("Bulunan:"+emp3);
    }
    
    
    
}
