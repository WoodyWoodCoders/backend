/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;


import fr.viacesi.webservicewood.dao.UtilisateurDAO;
import fr.viacesi.webservicewood.entity.Utilisateur;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.utils.Cryptage;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.servlet.ServletException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manuel Gonzalez
 */
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/user/jwt")
public class UserJWTController extends AbstractController {

    @Autowired
    private UtilisateurDAO utilisateurDao;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Utilisateur registerUser(@RequestBody Utilisateur utilisateur) throws NoSuchAlgorithmException {
        utilisateur.setPassword(utilisateur.getPassword());
        return utilisateurDao.save(utilisateur);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Utilisateur user) throws ServletException, NoSuchAlgorithmException {

        String jwtToken = "";
        JSONObject reponse = new JSONObject();
        if (user.getLogin() == null || user.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String login = user.getLogin();
        String password = user.getPassword();

        Utilisateur utilisateur = utilisateurDao.findByLogin(login);
        
        if (utilisateur == null) {
            throw new ServletException("User login not found.");
        }

        String pwd = utilisateur.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        System.out.println("utilisateur.getId()" + utilisateur.getId());
        jwtToken = Jwts.builder()
                .setSubject(login)
                .claim("roles", "utilisateur") // here we will put buyer/seller aswell
                .claim("utilisateur", utilisateur.getId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
        
        reponse.put("token", jwtToken);
        return reponse.toString();
        //return this.responseSuccess( jwtToken);
    }
}
