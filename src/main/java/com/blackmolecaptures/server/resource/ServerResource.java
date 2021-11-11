package com.blackmolecaptures.server.resource;

import com.blackmolecaptures.server.enumeration.Status;
import com.blackmolecaptures.server.model.Response;
import com.blackmolecaptures.server.model.Server;
import com.blackmolecaptures.server.service.implementation.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

/**
 * This class is the controller for our application.
 *
 *
 */
@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    private final ServerServiceImpl serverServiceImpl;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers(){
        HashMap<String, Collection<Server>> map = new HashMap<>();
        map.put("server", serverServiceImpl.list(20));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
//                        .data(Map("server", serverServiceImpl.list(27)))
                        .data(map)
                        .message("Servers Retrieved!!!")
                        .status(OK)
                        .StatusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverServiceImpl.ping(ipAddress);
        HashMap<String, Server> map = new HashMap<>();
        map.put("server", server);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
//                        .data(Map("server", serverServiceImpl.list(27)))
                        .data(map)
                        .message(server.getStatus() == Status.SERVER_UP ? "Ping Success!!": "Ping Failed!!!")
                        .status(OK)
                        .StatusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) throws IOException {
//        Server server = serverServiceImpl.ping(ipAddress);
        HashMap<String, Server> map = new HashMap<>();
        map.put("server", serverServiceImpl.create(server));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
//                        .data(Map("server", serverServiceImpl.list(27)))
                        .data(map)
                        .message("Server created !!!")
                        .status(CREATED)
                        .StatusCode(CREATED.value())
                        .build()
        );
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id){
        Server server = serverServiceImpl.get(id);
        HashMap<String, Server> map = new HashMap<>();
        map.put("server", server);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
//                        .data(Map("server", serverServiceImpl.list(27)))
                        .data(map)
                        .message("Server Retrieved!!")
                        .status(OK)
                        .StatusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id){
        Boolean server = serverServiceImpl.delete(id);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("server", server);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
//                        .data(Map("server", serverServiceImpl.list(27)))
                        .data(map)
                        .message("Server Deleted!!")
                        .status(OK)
                        .StatusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName")String fileName) throws IOException {

        return Files.readAllBytes(Paths.get("/Users/nikhilkalathil/Documents/Full Stack/server/src/main/java/com/blackmolecaptures/server/image/"+fileName));
    }

}
