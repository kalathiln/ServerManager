package com.blackmolecaptures.server.service;

import com.blackmolecaptures.server.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

/**
 *  Service lets us to provide different services through the application.
 *  Here we define the different functionalities that will be provided by the application.
 *
 */
public interface ServerService {
    /*
        Various functionalities supported by the application is listed here.
     */
    Server create(Server server);
    Server ping(String ipaddress) throws IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);


}
