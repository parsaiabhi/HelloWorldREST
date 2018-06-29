package com.matrix.rest.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.matrix.rest.model.Employee;

@Service
public class EmployeeService {

	private static final AtomicInteger counter = new AtomicInteger();
	
	private  List<Employee>  emp = null;
	{
		emp = populateEmployeeData();
	}
	
	public List<Employee> getAll(){
		return emp;
	}
	
	public Employee getById(int id){
		
		for(Employee emps:emp){
			if(emps.getId() == id){
				return emps;
			}
		}
		return null;
	}
	
	public Employee createEmp(Employee emps){
		List<Employee> empList = getAll();
		
		for(Employee empss: empList){
			
			if(empss.getName().equals(emps.getName())){
				
				break;
			}
			
		}
		emps.setId(counter.incrementAndGet());
		emp.add(emps);
		
		return emps;
	}
	
	
	
	
	private static List<Employee> populateEmployeeData(){
		List<Employee> empList = new ArrayList<Employee>();
		
		empList.add(new Employee(counter.incrementAndGet(),"manoj","noida",29393));
		empList.add(new Employee(counter.incrementAndGet(),"pooja","punjab",44393));
		empList.add(new Employee(counter.incrementAndGet(),"shyam","jaipur",12393));
		return empList;
	}
}
