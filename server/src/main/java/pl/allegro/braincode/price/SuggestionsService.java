package pl.allegro.braincode.price;

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
import java.util.stream.Collectors;

@Service
public class SuggestionsService {

    private static final float EXTENDED_DAYS_RATIO = 1.2f;
    private static final int DEFAULT_DAYS = 45;

    @Autowired
    private OffersRepository offersRepository;

    public Suggestion getSuggestion(OffersQuery offersQuery, Integer days, Integer minPrice) {

        if(days == null) {
            days = DEFAULT_DAYS;
        }

        final int finalDays = days;

        OffersList offersList = offersRepository.getOffersList(offersQuery);
        List<Double> prices = offersList.getOffers().stream()
                .map(offer -> offer.getPrices().getBuyNow())
                .filter(Objects::nonNull)
                .map(Price::getAmount)
                .collect(Collectors.toList());

        Suggestion suggestion = new Suggestion();

        if(prices == null || prices.isEmpty()) {
            return suggestion;
        }

        OptionalDouble max = prices.stream().mapToDouble(Double::doubleValue).max();
        OptionalDouble min = prices.stream().mapToDouble(Double::doubleValue).min();

        long extendedDays = Math.round(finalDays * EXTENDED_DAYS_RATIO);

        ArrayList<PriceDto> data = MockDataProvider.getData1((int) min.getAsDouble(), (int) max.getAsDouble(), (int) extendedDays);
        //TODO map from offers to PriceDtos
        //TODO fill gaps in data

        suggestion.setData(data);
        PriceDto bestPrice = data.stream()
                .filter(x -> x.getDaysToSell() <= finalDays)
                .max(Comparator.comparing(PriceDto::getPrice))
                .orElseGet(null);

        if (minPrice != null) {
            BigDecimal minPriceBigDec = new BigDecimal(minPrice);
            PriceDto fastest = data.stream()
                    .filter(x -> {
                        int i = x.getPrice().compareTo(minPriceBigDec);
                        return i == 1 || i == 0;
                    })
                    .min(Comparator.comparing(PriceDto::getDaysToSell))
                    .orElseGet(null);
            suggestion.setFastest(fastest);
        } else {
            PriceDto fastest = data.stream()
                    .min(Comparator.comparing(PriceDto::getDaysToSell))
                    .orElseGet(null);
            suggestion.setFastest(fastest);
        }
        suggestion.setBestPrice(bestPrice);
        return suggestion;
    }
}
