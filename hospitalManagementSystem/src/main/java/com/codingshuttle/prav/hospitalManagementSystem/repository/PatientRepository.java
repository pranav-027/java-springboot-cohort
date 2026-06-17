package com.codingshuttle.prav.hospitalManagementSystem.repository;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.prav.hospitalManagementSystem.model.BloodGroupStat;
import com.codingshuttle.prav.hospitalManagementSystem.model.IPatientResponse;
import com.codingshuttle.prav.hospitalManagementSystem.model.PatientInfo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query("select p.id as id, p.name as name, p.gender as gender from Patient p")
	List<IPatientResponse> getPatientInfo();  //read only


	@Query("select new com.codingshuttle.prav.hospitalManagementSystem.model.PatientInfo(p.id, p.name) " + "from Patient p")
	List<PatientInfo> getPatientInfoConcrete(); // can make changes but little complex


	@Query("select new com.codingshuttle.prav.hospitalManagementSystem.model.BloodGroupStat(p.bloodGroup," + "COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p) desc")
	List<BloodGroupStat> getBloodGroupStat();


	// updating record
	@Transactional
	@Modifying
	@Query("UPDATE Patient p set p.name = :name where p.id = :id")
	int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);


}

