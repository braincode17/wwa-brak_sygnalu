package pl.allegro.braincode.integration.allegro.auth;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import pl.allegro.braincode.utils.TextUtils;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class AuthServiceGenerator {

    public static final String API_BASE_URL = "https://ssl.allegro.pl";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create());

    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass, String clientId, String clientSecret) {
        if (!TextUtils.isEmpty(clientId) && !TextUtils.isEmpty(clientSecret)) {
            String authToken = Credentials.basic(clientId, clientSecret);
            return createService(serviceClass, authToken);
        }

        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }

        return retrofit.create(serviceClass);
    }
}
