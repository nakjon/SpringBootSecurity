package com.cdac.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.demo.model.Student;
import com.cdac.demo.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	 StudentRepo sRepo;
	
	public Student registerStudent(Student s) {
		return sRepo.save(s);
	}

	public Student getStudentInfo(String sname) {
		return sRepo.findBySname(sname);
	}

	public String getStudentRoles(String sname) {
		return sRepo.findBySname(sname).getSrole();
	}
}
