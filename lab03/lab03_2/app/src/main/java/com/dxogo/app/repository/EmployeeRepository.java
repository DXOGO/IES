package main.java.com.dxogo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.dxogo.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    public Employee findByEmailId(String emailId);
}
