package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
}
