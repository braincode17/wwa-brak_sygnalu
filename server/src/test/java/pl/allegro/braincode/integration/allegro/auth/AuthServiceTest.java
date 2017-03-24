package pl.allegro.braincode.integration.allegro.auth;

import org.junit.Test;
import retrofit2.Call;

import static org.junit.Assert.*;

public class AuthServiceTest {
    @Test
    public void auth() throws Exception {
        AuthService authService = new AuthService();
        AccessToken auth = authService.auth();
        assertNotNull(auth);
    }

}