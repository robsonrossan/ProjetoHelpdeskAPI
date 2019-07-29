package com.br.helpdesk.api.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.br.helpdesk.api.entity.User;
import com.br.helpdesk.api.enuns.ProfileEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
	}
	
	/**
	 * Metodo que CONVERTE E GERA um JWT User com base nos dados de um usuário
	 * @param user
	 * @return
	 */
	public static JwtUser create(User user) {
		
		return new JwtUser(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getProfile())
				);
	}

	/**
	 * Metodo que CONVERTE o perfil do usuário para o formato utilizado pelo SPRING SECURITY
	 * @param user
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
