package com.task.productmanagement.configuration;

import com.task.productmanagement.core.dto.response.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LogManager.getLogger(ExceptionHandler.class.getName());

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException exception) {

        List<String> messages = new ArrayList<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            messages.add(error.getDefaultMessage());
        });

        String errorMessage = String.join(" and ", messages);

        logger.error(errorMessage);

        ApiResponse response = new ApiResponse(errorMessage, HttpStatus.BAD_REQUEST.value(), null);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleCommonException(Exception exception) {

        logger.error(exception.getMessage());

        String errorMessage = "Error occurred during processing of request";

        ApiResponse response = new ApiResponse(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
