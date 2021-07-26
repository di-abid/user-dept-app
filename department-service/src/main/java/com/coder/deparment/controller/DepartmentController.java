package com.coder.deparment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deparment.entity.Department;
import com.coder.deparment.service.DepartmentService;



@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/getdepartment/{id}")
	public Department getDepartment(@PathVariable("id")Long departmentId) {
		return departmentService.getDepartment(departmentId);
	}
	
	@PutMapping("/update")
	public Department updateDepartment(Department department) {
		return departmentService.updateDepartment(department);
	}
}
