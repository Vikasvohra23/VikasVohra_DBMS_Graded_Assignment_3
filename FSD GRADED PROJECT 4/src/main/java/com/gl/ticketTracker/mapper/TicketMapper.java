package com.gl.ticketTracker.mapper;

import com.gl.ticketTracker.dto.TicketDto;
import com.gl.ticketTracker.entity.Ticket;

/**
 * Mapper class to convert between Ticket entity and Ticket DTO.
 */
public class TicketMapper {

    /**
     * Converts a Ticket entity to a TicketDto.
     *
     * @param ticket The Ticket entity to be converted.
     * @return The corresponding TicketDto.
     */
    public static TicketDto mapToTicketDto(Ticket ticket) {
        return TicketDto.builder()
                .id(ticket.getId()) // Map the ID from the entity to the DTO
                .title(ticket.getTitle()) // Map the title from the entity to the DTO
                .url(ticket.getUrl()) // Map the URL from the entity to the DTO
                .content(ticket.getContent()) // Map the content from the entity to the DTO
                .shortDescription(ticket.getShortDescription()) // Map the short description from the entity to the DTO
                .createdOn(ticket.getCreatedOn()) // Map the creation timestamp from the entity to the DTO
                .updatedOn(ticket.getUpdatedOn()) // Map the update timestamp from the entity to the DTO
                .build(); // Build and return the TicketDto object
    }

    /**
     * Converts a TicketDto to a Ticket entity.
     *
     * @param ticketDto The TicketDto to be converted.
     * @return The corresponding Ticket entity.
     */
    public static Ticket mapToTicket(TicketDto ticketDto) {
        return Ticket.builder()
                .id(ticketDto.getId()) // Map the ID from the DTO to the entity
                .title(ticketDto.getTitle()) // Map the title from the DTO to the entity
                .content(ticketDto.getContent()) // Map the content from the DTO to the entity
                .url(ticketDto.getUrl()) // Map the URL from the DTO to the entity
                .shortDescription(ticketDto.getShortDescription()) // Map the short description from the DTO to the entity
                .createdOn(ticketDto.getCreatedOn()) // Map the creation timestamp from the DTO to the entity
                .updatedOn(ticketDto.getUpdatedOn()) // Map the update timestamp from the DTO to the entity
                .build(); // Build and return the Ticket entity object
    }
}
