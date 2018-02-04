package fr.viacesi.webservicewood.controller;


import fr.viacesi.webservicewood.dto.UtilisateurDTO;
import fr.viacesi.webservicewood.entity.Utilisateur;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/user")
public class UserResourcesController extends AbstractSecureController {

    @Autowired
    private UtilisateurService UtilisateurService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Response> getUserInfos() {
        UtilisateurDTO utilisateur = this.getUtilisateur();
        return this.responseSuccess(utilisateur);
    }

    @RequestMapping(value = "/update/login", method = RequestMethod.POST)
    public UtilisateurDTO updateUser(@RequestBody Utilisateur user) {
        UtilisateurDTO current_utilisateur = this.getUtilisateur();
        return UtilisateurService.ChangeUtilisateurLogin(current_utilisateur, user.getLogin());
    }
}
