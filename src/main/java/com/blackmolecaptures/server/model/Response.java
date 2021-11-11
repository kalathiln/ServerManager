package com.blackmolecaptures.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Using this class in order to channel the response through this class to make the application more consistent.
 * The Response will be consistent no matter if it is a success or failure.
 */

@Data
@SuperBuilder // Builder pattern
@JsonInclude(NON_NULL) // only include values that are non null.
public class Response {
    protected LocalDateTime timeStamp;
    protected int StatusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected HashMap<?, ?> data;
}
