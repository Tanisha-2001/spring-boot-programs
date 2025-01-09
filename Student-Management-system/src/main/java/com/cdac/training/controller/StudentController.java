package com.cdac.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.model.Student;
import com.cdac.training.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
 List<Student> students=studentService.getAllStudent();
 return ResponseEntity.ok(students);
	}

	@PostMapping("")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student stud= studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(stud);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Optional<Student>> updateStudent(@PathVariable int id, @RequestBody Student student) {
		// TODO: process PUT request

		Optional<Student> updatedStudent= studentService.updateStudent(id, student);
		return ResponseEntity.ok().body(updatedStudent) ;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        if (studentService.getById(id).isPresent()) {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        }
        return ResponseEntity.notFound().build(); // HTTP 404 Not Found
    }

	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> getById(@PathVariable int id) {
		Optional<Student> stud= studentService.getById(id);
		return ResponseEntity.ok(stud);
		
	}
	
}
