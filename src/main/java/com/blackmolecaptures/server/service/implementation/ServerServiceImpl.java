package com.blackmolecaptures.server.service.implementation;

import com.blackmolecaptures.server.enumeration.Status;
import com.blackmolecaptures.server.model.Server;
import com.blackmolecaptures.server.repo.ServerRepo;
import com.blackmolecaptures.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("Saving new server : {}", server.getName());
        // Setting image for the server
        //server.setImageUrl(setServerImageUrl());

        return serverRepo.save(server);
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server1.png" , "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"+imageNames[new Random().nextInt(4)]).toUriString();
    }

    @Override
    public Server ping(String ipaddress) throws IOException {
        log.info("Pinging Server IP : {}", ipaddress);
        Server server = serverRepo.findByIpAddress(ipaddress);
        InetAddress address = InetAddress.getByName(ipaddress);
        server.setStatus(address.isReachable(10000)? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Finding list of first "+limit+" servers");
        // PageRequest.of lets you limit the number of page from a initial point to last point.
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching the server by ID : "+id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating Server : ", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server :", id);
        serverRepo.deleteById(id);
        return true;
    }
}
