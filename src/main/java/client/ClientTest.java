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

//        createEmployee(session);
        Employee employee =  session.get(Employee.class,2);
        if(employee!=null){
            employee.setSalary(13322.00);
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            System.out.println(employee);
        }else {
            System.out.println("Employee doesn't exist");
        }
    }

    public static void createEmployee(Session session) {
        Employee employee1 = getEmployee1();
        session.beginTransaction();
        session.persist(employee1);
        session.save(getEmployee2());
        session.saveOrUpdate(getEmployee3());
        session.getTransaction().commit();
    }

    public static Employee getEmployee1(){
        Employee employee = new Employee();
        employee.setDoj(new Date());
        employee.setEmail("rak@gmail.com");
        employee.setEmployeeName("rakesh");
        employee.setSalary(80000.00);
        return employee;
    }

    public static Employee getEmployee2(){
        Employee employee = new Employee();
        employee.setDoj(new Date());
        employee.setEmail("shiva@gmail.com");
        employee.setEmployeeName("shiva");
        employee.setSalary(60000.00);
        return employee;
    }

    public static Employee getEmployee3(){
        Employee employee = new Employee();
        employee.setDoj(new Date());
        employee.setEmail("john@gmail.com");
        employee.setEmployeeName("hohn");
        employee.setSalary(50000.00);
        return employee;
    }
}
