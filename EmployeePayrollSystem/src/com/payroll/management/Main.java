package com.payroll.management;

import java.util.ArrayList;

abstract class Employee{ 
	
	private String name; 
	private int id;  
	
	public Employee(String name,int id) {        					//constructor for class Employee
		this.name=name; 
		this.id=id;
	} 
	
	public String getName() { 
		return name;
	} 
	public int getId() { 
		return id;
	}
	public abstract double calculateSalary(); 
	
	public String toString() { 										//overriding toString method
		return "Employee[name="+name+" ,id="+id+",salary="+calculateSalary()+"]";
	}
	
} 
class FullTimeEmployee extends Employee{ 
	private double monthlySalary;
	
	public FullTimeEmployee(String name, int id, double monthlySalary)
	{ 
		super(name,id); 
		this.monthlySalary=monthlySalary;
	} 
	
	public double calculateSalary() { 					//overiding or providing implementation for abstract method
		return monthlySalary;
	}
}
class PartTimeEmployee extends Employee{  
	private int hoursWorked; 
	private double hourlyRate; 
	
	public PartTimeEmployee(String name,int id, int hoursWorked,double hourlyRate) 
	{ 
		super(name,id); 
		this.hoursWorked=hoursWorked; 
		this.hourlyRate=hourlyRate;
	} 
	public double calculateSalary() { 					//overiding or providing implementation for abstract method 
		return hoursWorked*hourlyRate;				
	}
	
}

class PayrollSystem{ 
	private ArrayList<Employee> employeeList; 
	
	public PayrollSystem() { 
		employeeList=new ArrayList<>();
	} 
	public void addEmployee(Employee employee) { 
		employeeList.add(employee);
	} 
	public void removeEmployee(int id) { 
		Employee employeeToRemove=null; 
		for(Employee employee : employeeList)
		{ 
			if(employee.getId()==id) 
			{ 
				employeeToRemove=employee; 
				break; 
			} 
		}
			if(employeeToRemove!=null)
			{ 
				employeeList.remove(employeeToRemove);
			}
				
		} 
	public void displayEmployees()
	{ 
		for(Employee employee:employeeList)
		{ 
			System.out.println(employee);
		}
	}
} 

public class Main {
	public static void main(String[] args) {
		PayrollSystem payrollSystem= new PayrollSystem(); 
		FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
	    PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);

	    payrollSystem.addEmployee(emp1);
	    payrollSystem.addEmployee(emp2);

	    System.out.println("Initial Employee Details:");
	    payrollSystem.displayEmployees();

	    System.out.println("\nRemoving Employee...");
	    payrollSystem.removeEmployee(101);

	    System.out.println("\nRemaining Employee Details:");
	     payrollSystem.displayEmployees();
		

	}

}
