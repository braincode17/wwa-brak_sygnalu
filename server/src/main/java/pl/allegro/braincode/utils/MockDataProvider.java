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

    public static ArrayList<PriceDto> getDataExp(int min, int max, int count) {
        ArrayList<PriceDto> yVals = new ArrayList<PriceDto>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double baseVal = max/Math.sqrt(count) * Math.pow(i,2);
            double distortion = 2 * baseVal * random.nextDouble() - baseVal;
            double adjustedDistortion = 0.2 * distortion;
            double chosen;
            if(baseVal - adjustedDistortion < 0) {
                chosen = baseVal;
            } else {
                chosen = baseVal - adjustedDistortion;
            }
            yVals.add(new PriceDto(i, BigDecimal.valueOf(chosen)));

//            float val = ((float)0.3f*random.nextFloat()*(max-min) - (max-min)/2 + max/Math.sqrt(count) * Math.pow(i,2));
//            float val = 0.02f * (max - min) * (random.nextFloat() * 2 - 1) + min;
//            yVals.add(new PriceDto(i, BigDecimal.valueOf(val)));
        }
        return yVals;
    }

    public static ArrayList<PriceDto> getData1(int min, int max, int count) {
        ArrayList<PriceDto> yVals = new ArrayList<PriceDto>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double baseVal = max/count * i;
            double distortion = 2 * baseVal * random.nextDouble() - baseVal;
            double adjustedDistortion = 0.2 * distortion;
            double chosen;
            if(baseVal - adjustedDistortion < 0 || baseVal - adjustedDistortion > max) {
                chosen = baseVal;
            } else {
                chosen = baseVal - adjustedDistortion;
            }
            yVals.add(new PriceDto(i, BigDecimal.valueOf(chosen)));

        }
        return yVals;
    }
}
