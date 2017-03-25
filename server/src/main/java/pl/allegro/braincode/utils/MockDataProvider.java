package pl.allegro.braincode.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import pl.allegro.braincode.messages.price.PriceDto;

public class MockDataProvider {
    public static ArrayList<PriceDto> getData(int min, int max, int count) {
        ArrayList<PriceDto> yVals = new ArrayList<PriceDto>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            float val = 0.3f*random.nextFloat()*(max-min) - (max-min)/2 + max/count*i;
//            float val = 0.02f * (max - min) * (random.nextFloat() * 2 - 1) + min;
            yVals.add(new PriceDto(i, BigDecimal.valueOf(val)));
        }
        return yVals;
    }
}
