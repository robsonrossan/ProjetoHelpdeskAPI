package com.br.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.br.helpdesk.api.entity.User;
import com.br.helpdesk.api.enuns.ProfileEnum;
import com.br.helpdesk.api.repository.UserRepository;

/**
 * 
 * @author robson.rosa
 *
 */
@SpringBootApplication
public class HelpDeskApplication {
	
	
	/**
	 * Continuar aula 51 
	 * 
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
	 * 
	 * @author robson.rosa
	 * 
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
