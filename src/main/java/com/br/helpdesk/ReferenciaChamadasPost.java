package com.br.helpdesk;

/**
 * Classe contendo os link's para ao teste dos serviços REST
 * 
 * @author robson.rosa
 *
 */
public class ReferenciaChamadasPost {
	
	/**
	 * ======================================================================= USUÁRIO =================================================================
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
	 	http://localhost:8080/api/user/5d4390ffc63cc21dfc99f1ca + Token no HEADER
	 */
	
	
	/**
  		USUARIO DELETE
 		http://localhost:8080/api/user/5d4390ffc63cc21dfc99f1ca + Token no HEADER
	 */
	
	
	
	/**
		USUARIO BUSCA POR PAGINA E QTDE REGISTROS
		http://localhost:8080/api/user/0/10 + Token no HEADER
	 */
	
	
/*
 ======================================================================= TICKET =================================================================	


-------------------------------------------------------- Chamada para gerar INSERIR TICKET ---------------------------  
POSTMAN = POST
http://localhost:8080/api/ticket + TOKEN
{
	"title" : "test title 4",
	"priority" : "NORMAL",
	"description" : "test description 4",
	"image" : "byte test"
}


-------------------------------------------------------- Chamada para gerar ALTERAR TICKET --------------------------- 
POSTMAN = PUT
http://localhost:8080/api/ticket + TOKEN
{
	"id": "5d439588c63cc21dfc99f1ce",
	"title" : "test title",
	"priority" : "NORMAL",
	"description" : "test description change",
	"image" : "byte test"
}

-------------------------------------------------------- Chamada para gerar BUSCA POR ID TICKET --------------------------- 
POSTMAN = GET
http://localhost:8080/api/ticket/5d43978ac63cc22b5cc844b1 + TOKEN


-------------------------------------------------------- Chamada para gerar DELETE TICKET --------------------------- 
POSTMAN = DELETE
http://localhost:8080/api/ticket/5d439588c63cc21dfc99f1ce + TOKEN

-------------------------------------------------------- Chamada para gerar BUSCA POR PARAMETROS TICKET --------------------------- 
POSTMAN = GET

								 {page}/{count}
http://localhost:8080/api/ticket/0/4 + TOKEN
OU 
								 {page}/{count}/{number}/{title}/{status}/{priority}
http://localhost:8080/api/ticket/0/4/0/test/new/NORMAL + TOKEN

http://localhost:8080/api/ticket/0/5



-------------------------------------------------------- Chamada para gerar ALTERAR STATUS TICKET --------------------------- 
POSTMAN = PUT
http://localhost:8080/api/ticket/5d4397a7c63cc22b5cc844b4/Resolved + TOKEN

-------------------------------------------------------- Chamada para gerar SUMMARY (TOTAL) TICKET --------------------------- 
POSTMAN = GET
http://localhost:8080/api/ticket/summary + TOKEN

*/
}