package pl.allegro.braincode.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.OffersQuery;
import pl.allegro.braincode.integration.OffersRepository;
import pl.allegro.braincode.integration.allegro.offers.OffersList;
import pl.allegro.braincode.messages.price.PriceDto;

import java.util.List;

@Service
public class PricesService {

    @Autowired
    private OffersRepository offersRepository;

    public List<PriceDto> getPrices(OffersQuery offersQuery) {
        OffersList offersList = offersRepository.getOffersList(offersQuery);
        //TODO map to list of priceDto
        return null;
    }
}
