package com.cdac.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.cdac.demo.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

	public Student findBySname(String sname);
}
