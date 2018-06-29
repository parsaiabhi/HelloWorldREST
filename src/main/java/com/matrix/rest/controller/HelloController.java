package com.matrix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.matrix.rest.model.Employee;
import com.matrix.rest.svc.EmployeeService;


/**
 * @author abhishek
 *
 */
@RestController
@RequestMapping("/greet")
public class HelloController {
//   http://localhost:8001/greet/name/ram
// hello
	@Autowired
	private EmployeeService svc;
	
//	http://localhost:8001/greet/create/emp
	@PostMapping("/create/emp")
	public ResponseEntity<?> enrollEmp(@RequestBody Employee emp,UriComponentsBuilder ucBuilder){
		Employee employee = svc.createEmp(emp);
		if(employee.getName().equals(emp.getName())){
			
			return new ResponseEntity<String>("duplicate name entry not allowed",HttpStatus.BAD_REQUEST);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/greet/user/emp/{id}").buildAndExpand(emp.getId()).toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.CREATED); 
		
	}
//  http://localhost:8001/greet/emp/displayall   
	@GetMapping("/emp/displayall")
	public ResponseEntity<List<Employee>> dispAllEmp(){
		List<Employee> empList = svc.getAll();
		
		if(empList.isEmpty()){
			
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		
		
	}
//	http://localhost:8001/greet/emp/{id}
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id){
		Employee emp = svc.getById(id);
		if(emp == null){
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
		
	}
	
		
		
		
		
		
		
		
	
	
	
}
