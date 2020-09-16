package dao;

import entities.Employee;

public interface EmployeeDAO {
    public abstract void addEmployee(Employee employee);
    public abstract void fetchEmployeeById(int employeeId);
    public abstract void updateEmployeeById(int employeeId, double newSal);
    public abstract void deleteEmployeeById(int employeeId);
}
