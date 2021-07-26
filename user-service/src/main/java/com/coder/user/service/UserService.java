/**
 * 
 */
package com.coder.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coder.user.entity.User;
import com.coder.user.repository.UserRepository;
import com.coder.user.vo.Department;
import com.coder.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author abidi
 *
 */
@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside Service: saveUser method");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside Service: getUserWithDepartment method");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user =  userRepository.findByUserId(userId);
		log.info("Calling Department Service for userId " + userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/getdepartment/"+user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
