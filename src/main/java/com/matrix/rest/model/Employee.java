package com.matrix.rest.model;

import java.util.Random;

public class Employee {

	private int id;
	private String name;
	private String add;
	private int sal;
	
	 
	
	 
	public Employee() {
		super();
	}





	public Employee(int id,String name, String add, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.add = add;
		this.sal = sal;
	}

	
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", add=" + add + ", sal=" + sal + "]";
	}
	
	
	
}
