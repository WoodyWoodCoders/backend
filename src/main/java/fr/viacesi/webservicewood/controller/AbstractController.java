/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;


import fr.viacesi.webservicewood.http.ErrorResponse;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.http.SuccessResponse;
import javax.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Manuel Gonzalez
 */
@ControllerAdvice
public abstract class AbstractController {

    public ResponseEntity<Response> responseError(String message) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
        return new ResponseEntity<Response>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Response> responseSuccess(Object message) {
        SuccessResponse res = new SuccessResponse(message);
        return new ResponseEntity<Response>(res, HttpStatus.OK);
    }

    public ResponseEntity<Response> responseSuccess(String key, String message) {
        SuccessResponse res = new SuccessResponse();
        res.addData(key, message);
        return new ResponseEntity<Response>(res, HttpStatus.OK);
    }
}
