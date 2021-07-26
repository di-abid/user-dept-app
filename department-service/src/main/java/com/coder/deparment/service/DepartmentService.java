package com.coder.deparment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.deparment.entity.Department;
import com.coder.deparment.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		return this.departmentRepository.save(department);
	}

	public Department getDepartment(Long departmentId) {
		return this.departmentRepository.findByDepartmentId(departmentId);
	}

	public Department updateDepartment(Department department) {
		return this.departmentRepository.save(department);
	}
}
