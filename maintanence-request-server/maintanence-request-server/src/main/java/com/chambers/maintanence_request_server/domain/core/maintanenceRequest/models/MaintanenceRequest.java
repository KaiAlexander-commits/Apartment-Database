package com.chambers.maintanence_request_server.domain.core.maintanenceRequest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Entity // JPA to save to the database
@NoArgsConstructor // Non-argument constructor
@RequiredArgsConstructor // Parameterized constructor
@Data // Getters and setters
public class MaintanenceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    @Column(name = "apt_number")
    private String aptNumber;

    @NonNull
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createAt; // Using LocalDateTime for timestamp

    // Optional: Override toString() if needed
    @Override
    public String toString() {
        return String.format("Request ID: %d, Tenant: %s %s, Email: %s, Apartment: %s, Description: %s, Created At: %s",
                id, firstName, lastName, email, aptNumber, description, createAt);
    }
}
