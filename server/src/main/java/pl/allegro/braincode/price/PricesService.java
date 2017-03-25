package pl.allegro.braincode.price;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegro.braincode.integration.OffersQuery;
import pl.allegro.braincode.integration.OffersRepository;
import pl.allegro.braincode.messages.price.PriceDto;

import java.util.List;

public class PricesService {
    @Autowired
    OffersRepository offersRepository;

    public List<PriceDto> getPrices(OffersQuery offersQuery) {
        return offersRepository.getOffersList(offersQuery);
    }
}
