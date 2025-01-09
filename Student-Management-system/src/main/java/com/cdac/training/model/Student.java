package com.cdac.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", initialValue = 100, allocationSize = 1)

	long StudentId;

	String studentName;
	String studentCourse;

	public Student() {
	}

	public Student(String studentName, String studentCourse) {
		this.studentName = studentName;
		this.studentCourse = studentCourse;
	}

	
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public long getStudentId() {
		return StudentId;
	}

	public void setStudentId(long studentId) {
		StudentId = studentId;
	}

}
