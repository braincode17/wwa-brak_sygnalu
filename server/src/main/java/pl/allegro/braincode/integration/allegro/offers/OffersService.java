package pl.allegro.braincode.integration.allegro.offers;

import pl.allegro.braincode.integration.allegro.auth.AuthService;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface OffersService {
    @Headers({
            "Api-Key:" + AuthService.API_KEY,
            "User-Agent:hackaton2017 (Client-Id " + AuthService.CLIENT_ID + ") Platform",
            "Accept: application/vnd.allegro.public.v1+json"
    })
    @GET("/offers")
    public Call<OffersList> offers(
            @Query("country.code") String countryCode,
            @Query("phrase") String phrase,
            @Query("category.id") String categoryId,
            @QueryMap Map<String, String> map
    );
}
