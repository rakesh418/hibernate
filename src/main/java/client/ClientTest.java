package client;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
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
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.createEmployee(getEmployee1());
        employeeService.createEmployee(getEmployee1());
        employeeService.updateEmployeeById(3, 20000);
        employeeService.deleteEmployeeById(2);
        employeeService.getEmployeeById(3);
    }

    public static Employee getEmployee1(){
        Employee employee = new Employee();
        employee.setDoj(new Date());
        employee.setEmail("rak@gmail.com");
        employee.setEmployeeName("rakesh");
        employee.setSalary(55555.00);
        return employee;
    }
}
