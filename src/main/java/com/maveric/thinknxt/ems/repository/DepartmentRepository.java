package com.maveric.thinknxt.ems.repository;

import com.maveric.thinknxt.ems.document.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, Long> {
}
