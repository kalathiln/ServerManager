package com.blackmolecaptures.server.model;

import com.blackmolecaptures.server.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


/**
 *
 * This is the class that denotes our Server object.
 * It contains an ID, an IPADDRESS, NAME, MEMORY,
 * TYPE, ImageURL, and STATUS.
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id // Using JPA
    @GeneratedValue(strategy = GenerationType.AUTO) // Using JPA
    private Long id;
    @Column(unique = true) // Using JPA
    @NotEmpty(message = "IP Address cannot be empty or null") // Using Validation
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
}
