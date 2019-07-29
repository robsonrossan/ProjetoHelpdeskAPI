package com.br.helpdesk.api.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.helpdesk.api.api.security.jwt.JwtUserFactory;
import com.br.helpdesk.api.entity.User;
import com.br.helpdesk.api.service.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	/**
	 * Metodo que faz a injeção de dependencia para carregar o usuário por EMAIL
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userService.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("Usuário não encontrado '%s'.", email));
		}else {
		
			return JwtUserFactory.create(user);
		}
	}
}
