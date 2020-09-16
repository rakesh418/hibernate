package service.impl;

import dao.impl.EmployeeDAOImpl;
import entities.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    public void createEmployee(Employee employee) {
        new EmployeeDAOImpl().addEmployee(employee);
    }

    public void getEmployeeById(int employeeId) {
        new EmployeeDAOImpl().fetchEmployeeById(employeeId);
    }

    public void updateEmployeeById(int employeeId, double newSal) {
        new EmployeeDAOImpl().updateEmployeeById(employeeId, newSal);
    }

    public void deleteEmployeeById(int employeeId) {
        new EmployeeDAOImpl().deleteEmployeeById(employeeId);
    }
}
