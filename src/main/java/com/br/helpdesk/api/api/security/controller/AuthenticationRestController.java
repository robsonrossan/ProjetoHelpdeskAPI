package com.br.helpdesk.api.api.security.controller;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.br.helpdesk.api.api.security.jwt.JwtAuthenticationRequest;
import com.br.helpdesk.api.api.security.jwt.JwtTokenUtil;
import com.br.helpdesk.api.api.security.model.CurrentUser;
import com.br.helpdesk.api.entity.User;
import com.br.helpdesk.api.service.UserService;

@RestController
@CrossOrigin(origins = "*") //permite acesso de qq ip ou porta
public class AuthenticationRestController {

	/**
	 * Injeção de dependencia da classe
	 */
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/**
	 * Injeção de dependencia da classe
	 */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	/**
	 * Injeção de dependencia da classe
	 */
	@Autowired
	UserDetailsService userDetailsService;
	
	/**
	 * Injeção de dependencia da classe
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * Metodo que faz a autorização passando um EMAIL e SENHA valido
	 * 
	 * @param authenticationRequest
	 * @return
	 * @throws AuthenticationException
	 */
	@PostMapping(value = "/api/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(),
				authenticationRequest.getPassword()
				)
			);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		final User user = userService.findByEmail(authenticationRequest.getEmail());
		user.setPassword(null);
		
		return ResponseEntity.ok(new CurrentUser(token, user));
	}
	
	@PostMapping(value = "/api/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request){
		String token = request.getHeader("Authorization");
		String username = jwtTokenUtil.getUsernameFromToken(token);
		final User user = userService.findByEmail(username);
		
		if(jwtTokenUtil.canTokenBeRefreshed(token)) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new CurrentUser(refreshedToken, user));
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
}
