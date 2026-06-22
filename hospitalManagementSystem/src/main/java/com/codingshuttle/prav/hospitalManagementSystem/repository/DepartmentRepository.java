package com.codingshuttle.prav.hospitalManagementSystem.repository;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
