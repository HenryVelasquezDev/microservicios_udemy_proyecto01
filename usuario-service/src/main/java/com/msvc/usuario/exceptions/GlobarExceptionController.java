package com.msvc.usuario.exceptions;

import com.msvc.usuario.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobarExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class )
    public ResponseEntity<ApiResponse> handlerResourceNotFoundExcepcion(ResourceNotFoundException resourceNotFoundException){
        String mensaje = resourceNotFoundException.getMessage();

        ApiResponse response = new ApiResponse().builder()
                .message(mensaje)
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
