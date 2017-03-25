package pl.allegro.braincode.suggestions;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class PriceCalculator {

    public static Entry getQuickest(ArrayList<Entry> chartValues) {
        if(chartValues == null || chartValues.isEmpty()) {
            return new Entry(0,0);
        }
        Entry minTime = chartValues.get(0);
        for (Entry chartValue : chartValues) {
            if(newTimeIsShorter(minTime, chartValue)
                    || newTimeIsEqualButNewPriceIsGreater(minTime, chartValue)) {
                minTime = chartValue;
            }
        }
        return minTime;
    }

    public static Entry getBestPrice(ArrayList<Entry> chartValues) {
        if(chartValues == null || chartValues.isEmpty()) {
            return new Entry(0,0);
        }
        Entry maxPrice = chartValues.get(0);
        for (Entry chartValue : chartValues) {
            if(newPriceIsGreater(maxPrice, chartValue)
                    || newPriceIsEqualButNewTimeIsShorter(maxPrice, chartValue)) {
                maxPrice = chartValue;
            }
        }
        return maxPrice;
    }

    private static boolean newPriceIsGreater(Entry maxPrice, Entry newPrice) {
        return newPrice.getY() > maxPrice.getY();
    }

    private static boolean newTimeIsShorter(Entry minTime, Entry newTime) {
        return newTime.getX() < minTime.getX();
    }

    private static boolean newPriceIsEqualButNewTimeIsShorter(Entry maxPrice, Entry newPrice) {
        return maxPrice.getY() == newPrice.getY() && maxPrice.getX() > newPrice.getX();
    }

    private static boolean newTimeIsEqualButNewPriceIsGreater(Entry minTime, Entry newTime) {
        return minTime.getX() == newTime.getX() && minTime.getY() < newTime.getY();
    }

}
