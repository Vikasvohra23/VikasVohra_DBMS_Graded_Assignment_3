package com.gl.ticketTracker.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gl.ticketTracker.dto.TicketDto;
import com.gl.ticketTracker.entity.Ticket;
import com.gl.ticketTracker.mapper.TicketMapper;
import com.gl.ticketTracker.repository.TicketRepository;
import com.gl.ticketTracker.service.TicketService;

/**
 * Implementation of TicketService interface that interacts with TicketRepository and TicketMapper.
 */
@Service
public class TicketServiceImpl implements TicketService {

    // Autowiring ticketRepository using constructor injection
    private final TicketRepository ticketRepository;

    /**
     * Constructor-based dependency injection for TicketRepository.
     *
     * @param ticketRepository The TicketRepository instance to be injected.
     */
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Retrieves all tickets from the repository and maps them to TicketDto objects.
     *
     * @return List of TicketDto objects representing all tickets.
     */
    @Override
    public List<TicketDto> findAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                      .map(TicketMapper::mapToTicketDto)
                      .collect(Collectors.toList());
    }

    /**
     * Creates a new ticket based on the provided TicketDto.
     *
     * @param ticketDto The TicketDto object containing ticket information.
     */
    @Override
    public void createTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToTicket(ticketDto);
        ticketRepository.save(ticket);
    }

    /**
     * Finds a ticket by its ID and maps it to TicketDto.
     *
     * @param ticketId The ID of the ticket to find.
     * @return TicketDto object representing the found ticket.
     */
    @Override
    public TicketDto findTickerById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        return TicketMapper.mapToTicketDto(ticket);
    }

    /**
     * Updates an existing ticket based on the provided TicketDto.
     *
     * @param ticketDto The TicketDto object containing updated ticket information.
     */
    @Override
    public void updateTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToTicket(ticketDto);
        ticketRepository.save(ticket);
    }

    /**
     * Deletes a ticket by its ID.
     *
     * @param ticketId The ID of the ticket to delete.
     */
    @Override
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    /**
     * Finds a ticket by its URL and maps it to TicketDto.
     *
     * @param ticketUrl The URL of the ticket to find.
     * @return TicketDto object representing the found ticket.
     */
    @Override
    public TicketDto findTicketByUrl(String ticketUrl) {
        Ticket ticket = ticketRepository.findByUrl(ticketUrl).orElse(null);
        return TicketMapper.mapToTicketDto(ticket);
    }

    /**
     * Searches for tickets based on a query string.
     *
     * @param query The search query string.
     * @return List of TicketDto objects matching the search criteria.
     */
    @Override
    public List<TicketDto> searchTickets(String query) {
        List<Ticket> tickets = ticketRepository.searchTickets(query);
        return tickets.stream()
                      .map(TicketMapper::mapToTicketDto)
                      .collect(Collectors.toList());
    }
}
