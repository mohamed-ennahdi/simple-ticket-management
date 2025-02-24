package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.TicketStatus;

public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long> {

}
