package com.br.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.helpdesk.api.entity.User;
import com.br.helpdesk.api.repository.UserRepository;
import com.br.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userServiceImpl;
	
	@Override
	public User findByEmail(String email) {
		return this.userServiceImpl.findByEmail(email);
	}

	@Override
	public User createOrUpdat(User user) {
		return this.userServiceImpl.save(user);
	}

	@Override
	public User findById(String id) {
		 return this.userServiceImpl.findOne(id); 
	}

	@Override
	public void delete(String id) {
		this.userServiceImpl.delete(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.userServiceImpl.findAll(pages);
	}

}
