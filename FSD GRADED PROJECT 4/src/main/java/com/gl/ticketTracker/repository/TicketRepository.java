package com.gl.ticketTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.ticketTracker.entity.Ticket;

/**
 * Repository interface for Ticket entity.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> { // Entity name and data type of the primary key

    /**
     * Finds a Ticket by its URL.
     * 
     * @param url The URL of the ticket.
     * @return An Optional containing the Ticket if found, or empty if not found.
     */
    Optional<Ticket> findByUrl(String url); // Spring JPA will create a query internally using Hibernate based on method name

    /**
     * Searches for tickets by title or short description.
     * 
     * @param query The search query string.
     * @return A list of tickets matching the search query.
     */
    @Query("SELECT p from Ticket p WHERE " +
           " p.title LIKE CONCAT('%', :query, '%') OR " +
           " p.shortDescription LIKE CONCAT('%', :query, '%')")
    List<Ticket> searchTickets(String query); // JPQL query to search tickets based on title or short description
}
