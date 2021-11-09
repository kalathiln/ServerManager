package com.blackmolecaptures.server.repo;

import com.blackmolecaptures.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
    // Naming has to be taken into consideration.
    // Find by tells the JPA to find by ip address from the resource that it has
    // findby tells the JPA to select
    // Look for

    Server findByIpAddress(String ipAddress);


}
