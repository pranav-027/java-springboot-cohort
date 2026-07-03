package com.codingshuttle.prav.production_ready_features;

import com.codingshuttle.prav.production_ready_features.clients.EmployeeClient;
import com.codingshuttle.prav.production_ready_features.dto.EmployeeDto;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;


	@Test
	@Order(3)
	void callEmployeeApi() {
		List<EmployeeDto> employeeDtoList = employeeClient.getAllEmployees();

		System.out.println(employeeDtoList);

	}

	@Test
	@Order(2)
	void getEmpById() {
		EmployeeDto employeeDto = employeeClient.getEmployeeById(2L);
		System.out.println(employeeDto);
	}

	@Test
	@Order(1)
	void createNewEmp(){
		EmployeeDto employeeDto = EmployeeDto.builder()
				.name("Karan")
				.age(2)
				.email("karan@testing.com")
				.salary(123000.22)
				.role("USER")
				.build();

		System.out.println(employeeClient.createNewEmployee(employeeDto));
	}

}
