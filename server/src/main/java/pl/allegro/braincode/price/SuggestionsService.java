package pl.allegro.braincode.price;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.OffersQuery;
import pl.allegro.braincode.integration.OffersRepository;
import pl.allegro.braincode.integration.allegro.offers.OffersList;
import pl.allegro.braincode.integration.allegro.offers.Price;
import pl.allegro.braincode.messages.price.PriceDto;
import pl.allegro.braincode.messages.price.Suggestion;
import pl.allegro.braincode.utils.MockDataProvider;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SuggestionsService {

    @Autowired
    private OffersRepository offersRepository;

    public Suggestion getSuggestion(OffersQuery offersQuery) {

        OffersList offersList = offersRepository.getOffersList(offersQuery);
        List<Double> prices = offersList.getOffers().stream()
                .map(offer -> offer.getPrices().getBuyNow())
                .filter(Objects::nonNull)
                .map(Price::getAmount)
                .collect(Collectors.toList());

        OptionalDouble max = prices.stream().mapToDouble(Double::doubleValue).max();
        OptionalDouble min = prices.stream().mapToDouble(Double::doubleValue).min();
        ArrayList<PriceDto> data = MockDataProvider.getDataExp((int) min.getAsDouble(), (int) max.getAsDouble(), 90);
        //TODO map from offers to PriceDtos
        //TODO fill gaps in data

        Suggestion suggestion = new Suggestion();
        suggestion.setData(data);
        PriceDto bestPrice = data.stream()
                .max(Comparator.comparing(PriceDto::getPrice))
                .orElseGet(null);

        PriceDto fastest = data.stream()
                .min(Comparator.comparing(PriceDto::getDaysToSell))
                .orElseGet(null);

        suggestion.setBestPrice(bestPrice);
        suggestion.setFastest(fastest);
        return suggestion;
    }
}
