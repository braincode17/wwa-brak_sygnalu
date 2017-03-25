package pl.allegro.braincode.integration;

import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.allegro.auth.PublicServiceGenerator;
import pl.allegro.braincode.integration.allegro.offers.OffersList;
import pl.allegro.braincode.integration.allegro.offers.OffersService;

import java.io.IOException;

@Service
public class OffersRepository {

    private final OffersService service = PublicServiceGenerator.createService(OffersService.class);

    public OffersList getOffersList(OffersQuery offersQuery) {
        try {
            return service
                    .offers(offersQuery.getQueryParams())
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException("Error during getting offers", e);
        }
    }

}
