package pl.allegro.braincode.integration.allegro.auth;

import org.springframework.stereotype.Service;
import retrofit2.Call;

@Service
public class AuthService {

    private String clientID = "a41f5b2a-8e87-4b8b-b6fe-74cc763720d7";
    private String clientSecret = "bxbb2gFqCP1aM3kNPeptAWQMGz9gosbe9JCO1sqlp0BhY9G4UufpkXgsSFQYE545";
    private String apiKey = "eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=";
    private String grantType = "client_credentials";

    public Call<AccessToken> auth() {
        AuthAllegroService service = AuthServiceGenerator.createService(AuthAllegroService.class, clientID, clientSecret);
        Call<AccessToken> auth = service.auth(grantType);
        return auth;
    }

}
