package com.cdac.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.demo.model.Student;
import com.cdac.demo.service.StudentService;

@RestController
public class SpringSecurityControlle {

	   StudentService service;
	   PasswordEncoder encoder;
	   
	public SpringSecurityControlle(StudentService service, PasswordEncoder encoder) {
		
		this.service = service;
		this.encoder = encoder;
	}
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student)
	{
	Student s=new Student();
	s.setSname(student.getSname());
	s.setSrole(student.getSrole());
	s.setPassword(encoder.encode(student.getPassword()));
	return service.registerStudent(s);
	}
	
	@GetMapping("/studentInfo")
	public Student getstudentInfo(@RequestParam("sname") String sname )
	{
		return service.getStudentInfo(sname); 
	}
	
	@GetMapping("/studentrole/{sname}")
	public String getstudentRole(@PathVariable("sname") String sname )
	{
		return service.getStudentRoles(sname);             
	}
	   
	   
}
