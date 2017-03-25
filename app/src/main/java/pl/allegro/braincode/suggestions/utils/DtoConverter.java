package pl.allegro.braincode.suggestions.utils;


import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.allegro.braincode.messages.price.PriceDto;
import pl.allegro.braincode.messages.price.Suggestion;

public class DtoConverter {

    public static Entry convert(PriceDto priceDto) {
        float price = priceDto.getPrice().floatValue();
        float days;
        if (priceDto.getPrice() == null) {
            days = 0f;
        } else {
            days = priceDto.getDaysToSell();
        }
        return new Entry(days, price);
    }

    public static List<Entry> convert(Suggestion suggestions) {
        if(suggestions.getData() == null) {
            return Collections.emptyList();
        }
        List<Entry> entries = new ArrayList<>();
        for (PriceDto dto : suggestions.getData()) {
            entries.add(convert(dto));
        }
        return entries;
    }
}