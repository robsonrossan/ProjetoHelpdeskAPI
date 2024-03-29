package com.br.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
