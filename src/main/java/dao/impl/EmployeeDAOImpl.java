package dao.impl;

import dao.EmployeeDAO;
import entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

    public void addEmployee(Employee employee) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Emplyee created with id: "+id);
            session.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
            System.out.println("Error in creation");
        }
    }

    public void fetchEmployeeById(int employeeId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee employee = session.get(Employee.class,employeeId);
            if(employee!=null){
                System.out.println(employee);
            }else{
                System.out.println("Employee does not exist with given id");
            }
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }

    public void updateEmployeeById(int employeeId, double newSal) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee employee = session.get(Employee.class,employeeId);
            if(employee!=null){
                employee.setSalary(newSal);
                session.beginTransaction();
                session.update(employee);
                session.getTransaction().commit();
            }else{
                System.out.println("Employee does not exist with given id");
            }
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }

    public void deleteEmployeeById(int employeeId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee employee = session.get(Employee.class,employeeId);
            if(employee!=null){
                session.beginTransaction();
                session.delete(employee);
                session.getTransaction().commit();
            }else{
                System.out.println("Employee does not exist with given id");
            }
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
}
