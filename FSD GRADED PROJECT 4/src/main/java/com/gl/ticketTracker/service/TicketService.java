package com.gl.ticketTracker.service;

import java.util.List;

import com.gl.ticketTracker.dto.TicketDto;

/**
 * Service interface for Ticket operations.
 * This interface defines the methods for managing tickets.
 */
public interface TicketService {

    /**
     * Retrieves all tickets.
     *
     * @return A list of TicketDto representing all tickets.
     */
    List<TicketDto> findAllTickets();

    /**
     * Creates a new ticket.
     *
     * @param ticketDto The TicketDto representing the ticket to be created.
     */
    void createTicket(TicketDto ticketDto);

    /**
     * Finds a ticket by its ID.
     *
     * @param ticketId The ID of the ticket to be found.
     * @return The TicketDto representing the found ticket.
     */
    TicketDto findTickerById(Long ticketId);

    /**
     * Updates an existing ticket.
     *
     * @param ticketDto The TicketDto representing the updated ticket.
     */
    void updateTicket(TicketDto ticketDto);

    /**
     * Deletes a ticket by its ID.
     *
     * @param ticketId The ID of the ticket to be deleted.
     */
    void deleteTicket(Long ticketId);

    /**
     * Finds a ticket by its URL.
     *
     * @param ticketUrl The URL of the ticket to be found.
     * @return The TicketDto representing the found ticket.
     */
    TicketDto findTicketByUrl(String ticketUrl);

    /**
     * Searches for tickets by a query string.
     *
     * @param query The search query string.
     * @return A list of TicketDto representing the matching tickets.
     */
    List<TicketDto> searchTickets(String query);
}
