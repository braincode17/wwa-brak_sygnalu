package pl.allegro.braincode.integration;

import org.junit.Test;
import pl.allegro.braincode.integration.allegro.offers.OffersList;

import static org.junit.Assert.*;

public class OffersRepositoryTest {
    @Test
    public void getOffersList() throws Exception {
        OffersRepository offersRepository = new OffersRepository();
        OffersList offersList = offersRepository.getOffersList("PL", "iphone");
        System.out.println(offersList.getCount());
    }

}