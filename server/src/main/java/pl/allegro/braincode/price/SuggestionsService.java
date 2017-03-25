package pl.allegro.braincode.price;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.OffersQuery;
import pl.allegro.braincode.integration.OffersRepository;
import pl.allegro.braincode.integration.allegro.offers.OffersList;
import pl.allegro.braincode.messages.price.PriceDto;
import pl.allegro.braincode.messages.price.Suggestion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SuggestionsService {

    @Autowired
    private OffersRepository offersRepository;

    public Suggestion getSuggestion(OffersQuery offersQuery) {

        OffersList offersList = offersRepository.getOffersList(offersQuery);
        List<PriceDto> prices = offersList.getOffers().stream()
                .map(o -> new PriceDto(new Random(System.nanoTime()).nextInt(90), new BigDecimal(o.getPrices().getCurrent().getAmount())))
                .collect(Collectors.toList());


        //TODO map from offers to PriceDtos
        //TODO fill gaps in data


        Suggestion suggestion = new Suggestion();
        suggestion.setData(prices);
        PriceDto bestPrice = prices.stream()
                .max(Comparator.comparing(PriceDto::getPrice))
                .orElseGet(null);

        PriceDto fastest = prices.stream()
                .min(Comparator.comparing(PriceDto::getDaysToSell))
                .orElseGet(null);

        suggestion.setBestPrice(bestPrice);
        suggestion.setFastest(fastest);
        return suggestion;
    }
}
