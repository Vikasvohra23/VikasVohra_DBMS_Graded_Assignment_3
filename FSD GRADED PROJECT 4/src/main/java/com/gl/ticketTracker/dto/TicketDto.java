package com.gl.ticketTracker.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for the Ticket entity.
 * This class is used to transfer data between layers in the application.
 */
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@Builder // Lombok annotation to implement the builder pattern
@NoArgsConstructor // Lombok annotation to generate a no-args constructor
@AllArgsConstructor // Lombok annotation to generate an all-args constructor
public class TicketDto {

    private Long id; // Unique identifier for the ticket

    @NotEmpty // Validation annotation to ensure the title is not empty
    private String title; // Title of the ticket

    private String url; // URL slug derived from the title

    @NotEmpty // Validation annotation to ensure the content is not empty
    private String content; // Detailed content of the ticket

    @NotEmpty // Validation annotation to ensure the short description is not empty
    private String shortDescription; // Short description or summary of the ticket

    private LocalDateTime createdOn; // Timestamp for when the ticket was created

    private LocalDateTime updatedOn; // Timestamp for when the ticket was last updated
}
