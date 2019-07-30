package com.br.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.br.helpdesk.api.entity.User;
import com.br.helpdesk.api.enuns.ProfileEnum;
import com.br.helpdesk.api.repository.UserRepository;

@SpringBootApplication
public class HelpDeskApplication {
	
	
	/**
	 * TODAS AS CHAMADAS E VIA POSTAMAN  
	 * 
	 * URL Gerar Token: "http://localhost:8080/api/auth" + Token no HEADER
	 * 
	 * URL Inserir Usuário: "http://localhost:8080/api/user" + Token no HEADER
	 * {
			"email" : "EMAIL@hotmail.com",
			"password" : "123456",
			"profile" : "ROLE_ADMIN"
		}
	 * 
	 * URL Alterar Usuário: "Mesmo do inserir, com o json alterado" + Token no HEADER
	 * {
			"id": "5d4035b6298402322cef006e",
			"email" : "robson@gmail.com",
			"password" : "123456",
			"profile" : "ROLE_ADMIN"
		}
	 * 
	 * URL: Busca Por ID: "http://localhost:8080/api/user/5d3b473383e636196028d2dc" + Token no HEADER
	 * 
	 * URL DELETE USUARIO: http://localhost:8080/api/user/5d4038c8298402322cef0076
	 * 
	 * URL: BUSCA POR PAGINA E QTDE REGISTROS: "http://localhost:8080/api/user/0/10" + Token no HEADER
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};
	}
	
	/**
	 * Ao Iniciar aplicação já será criado o usuario "admin" com ROLE ADMIN
	 * @param userRepository
	 * @param passwordEncoder
	 */
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@helpdesk.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User find = userRepository.findByEmail("admin@helpdesk.com");
		if(find == null) {
			userRepository.save(admin);
		}
	}
}
