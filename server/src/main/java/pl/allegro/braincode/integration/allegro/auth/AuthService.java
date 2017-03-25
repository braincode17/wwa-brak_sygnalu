package pl.allegro.braincode.integration.allegro.auth;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService {

    public static final String API_KEY = "eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=";
    public static final String CLIENT_ID = "a41f5b2a-8e87-4b8b-b6fe-74cc763720d7";
    public static final String CLIENT_SECRET = "bxbb2gFqCP1aM3kNPeptAWQMGz9gosbe9JCO1sqlp0BhY9G4UufpkXgsSFQYE545";
    public static final String GRANT_TYPE = "client_credentials";

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
                .createService(AuthAllegroService.class, CLIENT_ID, CLIENT_SECRET)
                .auth(GRANT_TYPE)
                .execute()
                .body();
    }

}
