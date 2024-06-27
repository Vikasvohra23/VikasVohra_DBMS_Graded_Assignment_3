package com.gl.ticketTracker.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing the Ticket entity in the database.
 * This class is annotated with JPA and Hibernate annotations for ORM mapping.
 */
@Getter // Lombok annotation to generate getter methods for all fields
@Setter // Lombok annotation to generate setter methods for all fields
@NoArgsConstructor // Lombok annotation to generate a no-arguments constructor
@AllArgsConstructor // Lombok annotation to generate an all-arguments constructor
@Builder // Lombok annotation to implement the builder pattern for the class
@Entity // JPA annotation to indicate that this class is a JPA entity
@Table(name = "tickets") // JPA annotation to specify the table name in the database
public class Ticket {

    @Id // JPA annotation to mark the field as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long id; // Unique identifier for the ticket

    @Column(nullable = false) // JPA annotation to specify column details, here it ensures that the column cannot be null
    private String title; // Title of the ticket

    @Column(nullable = false) // Ensures that the URL column cannot be null
    private String url; // URL-friendly slug derived from the title

    @Lob // JPA annotation to indicate that the field should be treated as a large object
    @Column(nullable = false) // Ensures that the content column cannot be null
    private String content; // Detailed content of the ticket

    private String shortDescription; // Short description or summary of the ticket

    @CreationTimestamp // Hibernate annotation to automatically set the creation timestamp
    private LocalDateTime createdOn; // Timestamp for when the ticket was created

    @UpdateTimestamp // Hibernate annotation to automatically set the update timestamp
    private LocalDateTime updatedOn; // Timestamp for when the ticket was last updated
}
