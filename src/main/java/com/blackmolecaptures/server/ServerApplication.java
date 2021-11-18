package com.blackmolecaptures.server;

import com.blackmolecaptures.server.enumeration.Status;
import com.blackmolecaptures.server.model.Server;
import com.blackmolecaptures.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    // Bean commandline runner bean

    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server(null, "192.168.1.160", "UBUNTU LINUX", "16 GB", "Personal PC", "http://localhost:8080/server/image/server1.png",
                    Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.168.1.161", "MACOS", "16 GB", "Personal PC", "http://localhost:8080/server/image/server2.png",
                    Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.168.1.162", "Windows", "16 GB", "Personal PC", "http://localhost:8080/server/image/server3.png",
                    Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.168.1.163", "NAS", "16 GB", "Personal PC", "http://localhost:8080/server/image/server4.png",
                    Status.SERVER_DOWN));
        };
    };
}
