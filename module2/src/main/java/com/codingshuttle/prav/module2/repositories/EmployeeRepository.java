package com.codingshuttle.prav.module2.repositories;


import com.codingshuttle.prav.module2.entities.EmployeeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
