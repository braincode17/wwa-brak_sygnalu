package pl.allegro.braincode.integration.allegro.auth;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService {

    private static final String clientID = "a41f5b2a-8e87-4b8b-b6fe-74cc763720d7";
    private static final String clientSecret = "bxbb2gFqCP1aM3kNPeptAWQMGz9gosbe9JCO1sqlp0BhY9G4UufpkXgsSFQYE545";
    //    private static final String apiKey = "eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=";
    private static final String grantType = "client_credentials";

    private AccessToken accessToken;

    public AccessToken auth() {
        if (accessToken == null) {
            try {
                accessToken = requestNewToken();
            } catch (IOException e) {
                throw new RuntimeException("Error during getting access token", e);
            }
        }
        return accessToken;
    }

    private AccessToken requestNewToken() throws IOException {
        return AuthServiceGenerator
                .createService(AuthAllegroService.class, clientID, clientSecret)
                .auth(grantType)
                .execute()
                .body();
    }

}
