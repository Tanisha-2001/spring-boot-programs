package com.cdac.training.spring.SpringCore.model;

public class Employee {
  String name;
  int sal;
public Employee(String name, int sal) {
	super();
	this.name = name;
	this.sal = sal;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}public void display()
{
	System.out.println(name+ " "+sal);
}

}
