package com.codingshuttle.prav.hospitalManagementSystem.repository;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
