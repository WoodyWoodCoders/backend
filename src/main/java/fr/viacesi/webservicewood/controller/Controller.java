/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mgonzalez
 */
@RestController
public class Controller {
    @RequestMapping("/woodwebservice")
    public String get() {
        return "Web Service Wood ok le : " + new Date().toLocaleString();    
    }
}
