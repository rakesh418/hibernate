package client;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.Date;

public class ClientTest {
//    public static void main(String[] args) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            String sql = "SELECT version();";
//            String result = (String) session.createNativeQuery(sql).getSingleResult();
//            System.out.println("MYSQL version is: "+result);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee = getEmployee();
        session.beginTransaction();
        session.persist(  employee);
        session.save(employee);
        session.getTransaction().commit();

    }

    public static Employee getEmployee(){
        Employee employee = new Employee();
        employee.setDoj(new Date());
        employee.setEmail("rak@gmail.com");
        employee.setEmployeeName("rakesh");
        employee.setSalary(80000.00);
        return employee;
    }
}
