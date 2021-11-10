package com.blackmolecaptures.server.enumeration;

/***
 * The enumeraions tell us about the status of the server,
 * Server UP denotes that the Server is up and runing
 * SERVER DOWN represents the server either the Server is currently not pingable or it does not exist.
 *
 */

public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;


    Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
