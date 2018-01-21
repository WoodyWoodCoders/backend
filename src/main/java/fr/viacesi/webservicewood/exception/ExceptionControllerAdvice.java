/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.exception;

import fr.viacesi.webservicewood.http.ErrorResponse;
import fr.viacesi.webservicewood.http.Response;
import javax.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author mgonzalez
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(ServletException.class)
    public ResponseEntity<Response> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<Response>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
