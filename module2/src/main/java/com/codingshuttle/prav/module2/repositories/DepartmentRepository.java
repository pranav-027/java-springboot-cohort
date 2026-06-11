package com.codingshuttle.prav.module2.repositories;

import com.codingshuttle.prav.module2.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
