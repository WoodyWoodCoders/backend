/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.http;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

/**
 *
 * @author mgonzalez
 */
public class ErrorResponse implements Response {

    private HttpStatus errorCode;
    private String message;

    public ErrorResponse(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
    
    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString(){
        return new JSONObject()
                .put("error", this.message)
                .toString();
    }
    
}
