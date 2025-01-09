package com.cdac.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.model.Student;
import com.cdac.training.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();

	}

	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}

	public Optional<Student> updateStudent(int id, Student student) {
	    student.setStudentId(id);
	    Optional<Student> stud = studentRepository.findById(id);
	    if (stud.isPresent()) {
	        Student st = stud.get();
	        st.setStudentName(student.getStudentName() != null ? student.getStudentName() : st.getStudentName());
	        st.setStudentCourse(student.getStudentCourse() != null ? student.getStudentCourse() : st.getStudentCourse());
	        studentRepository.save(st);
	        return stud;
	    }
	    return null;
	}


	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
		;

	}

	public Optional<Student> getById(int id) {

		return studentRepository.findById(id);
	}

}
