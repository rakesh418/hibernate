package service;

import entities.Employee;

public interface EmployeeService {
    public void createEmployee(Employee employee);
    public void getEmployeeById(int employeeId);
    public void updateEmployeeById(int employeeId, double newSal);
    public void deleteEmployeeById(int employeeId);
}
