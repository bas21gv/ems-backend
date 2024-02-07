package com.maveric.thinknxt.ems.repository;

import com.maveric.thinknxt.ems.document.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
}
