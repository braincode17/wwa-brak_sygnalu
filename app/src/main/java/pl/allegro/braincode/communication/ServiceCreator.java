package pl.allegro.braincode.communication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreator {

    private final static String BASE_URL = "http://172.18.198.98:8080";

    public static ServerService createServerService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ServerService.class);
    }
}
