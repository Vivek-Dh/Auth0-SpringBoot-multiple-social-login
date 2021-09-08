package com.auth0.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for requests to the {@code /profile} resource. Populates the model with the claims from the
 * {@linkplain OidcUser} for use by the view.
 */
@Controller
public class ProfileController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String namespace = "https://dev-ggtycsos.com/vivekdh45/";

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OidcUser oidcUser) throws JsonProcessingException {
        String connection = oidcUser.getClaim(namespace+"connection");
        if(connection.equalsIgnoreCase("github")) {
            Map<String, Object> github = new ObjectMapper().readValue(oidcUser.getClaims().get(namespace + "github").toString(), HashMap.class);
            model.addAttribute("github",github);
        }
        else if(connection.equalsIgnoreCase("stackexchange")){
            Map<String, Object> user = new ObjectMapper().readValue(oidcUser.getClaims().get(namespace + "stackexchange").toString(), HashMap.class);
            Map<String, Object> so = (Map<String, Object>) user.get("user_metadata");
            model.addAttribute("so",so);
        }
        model.addAttribute("profile", oidcUser.getClaims());
        model.addAttribute("profileJson", claimsToJson(oidcUser.getClaims()));
        return "profile";
    }

    private String claimsToJson(Map<String, Object> claims) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(claims);
        } catch (JsonProcessingException jpe) {
            log.error("Error parsing claims to JSON", jpe);
        }
        return "Error parsing claims to JSON.";
    }
}
