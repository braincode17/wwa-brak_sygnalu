package pl.allegro.braincode.integration.allegro.category;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import pl.allegro.braincode.integration.allegro.auth.AuthenticationInterceptor;
import pl.allegro.braincode.utils.TextUtils;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.natelefon.pl";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create());

    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass) {
        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

}
