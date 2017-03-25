package pl.allegro.braincode.suggestions.utils;


import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;

import java.util.ArrayList;

public class MockDataProvider {
    public static ArrayList<Entry> getData() {
        int count = 36;
        float range = 100;

        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 3*i;
            yVals.add(new Entry(i, val));
        }
        return yVals;
    }
}
