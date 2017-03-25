package pl.allegro.braincode.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.allegro.auth.AuthService;
import pl.allegro.braincode.integration.allegro.auth.PublicServiceGenerator;
import pl.allegro.braincode.integration.allegro.auth.ServiceGenerator;
import pl.allegro.braincode.integration.allegro.category.CategoriesService;
import pl.allegro.braincode.integration.allegro.category.Category;
import pl.allegro.braincode.integration.allegro.offers.OffersList;
import pl.allegro.braincode.integration.allegro.offers.OffersService;

import java.io.IOException;
import java.util.List;

@Service
public class OffersRepository {

    private final OffersService service = PublicServiceGenerator.createService(OffersService.class);

    public OffersList getOffersList(String countryCode, String phrase) {
        try {
            return service
                    .offers(countryCode, phrase)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException("Error during getting offers", e);
        }
    }

}
