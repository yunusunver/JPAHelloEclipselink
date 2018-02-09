/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _01.hello.eclipselink.dao;

import _01.hello.eclipselink.model.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author unver
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    public EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    
    @Override
    public Employee insertEmployee(int id, String name, String surname, int salary) {
        Employee eklenecekVeri=new Employee(id,name, surname, salary);
        entityManager.getTransaction().begin();
        entityManager.persist(eklenecekVeri);
        entityManager.getTransaction().commit();
        return eklenecekVeri;
    }

    @Override
    public List<Employee> listEmployee() {
        @SuppressWarnings("JPQLValidation")
        Query query=entityManager.createQuery("select e Emloyee e");
        return query.getResultList();
    }

    @Override
    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void removeEmployee(int id) {
        Employee employee=findEmployee(id);
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee raiseSalary(int id, int salary) {
        Employee employee=findEmployee(id);
        entityManager.getTransaction().begin();
        employee.setSalary(employee.getSalary()+salary);
        entityManager.getTransaction().commit();
        return employee;
    }
    
}
