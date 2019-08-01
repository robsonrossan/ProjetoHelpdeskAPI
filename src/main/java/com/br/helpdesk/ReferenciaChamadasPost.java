package com.br.helpdesk;

/**
 * Classe contendo os link's para ao teste dos serviços REST
 * 
 * @author robson.rosa
 *
 */
public class ReferenciaChamadasPost {
	
	/**
	 ************** 	Chamada no Postman deve ser; POST **************
		 Chamada para gerar o TOKEN
		 http://localhost:8080/api/auth
 	 	{
			"email" : "admin@helpdesk.com",
			"password" : "123456"
		}
	 */
	
	
	/**
	  	Chamada para gerar Inserir Usuário 
	 	http://localhost:8080/api/user + Token no HEADER
	 	{
			"email" : "EMAIL@hotmail.com",
			"password" : "123456",
			"profile" : "ROLE_ADMIN"
		}

	 */
	
	
	/**
	 	Chamada para Alterar Usuário 
	 	http://localhost:8080/api/user + Token no HEADER
		{
			"id": "5d4035b6298402322cef006e",
			"email" : "EMAIL@gmail.com",
			"password" : "123456",
			"profile" : "ROLE_ADMIN"
		}
		
	 */
	
	
	/**
	  	Usuário Busca Por ID
	 	http://localhost:8080/api/user/5d3b473383e636196028d2dc + Token no HEADER
	 */
	
	
	/**
  		USUARIO DELETE
 		http://localhost:8080/api/user/5d4038c8298402322cef0076 + Token no HEADER
	 */
	
	
	
	/**
		USUARIO BUSCA POR PAGINA E QTDE REGISTROS
		http://localhost:8080/api/user/0/10 + Token no HEADER
	 */
}
