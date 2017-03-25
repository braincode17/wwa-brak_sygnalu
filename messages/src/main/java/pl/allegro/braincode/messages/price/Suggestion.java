package pl.allegro.braincode.messages.price;

import java.util.List;

public class Suggestion {
    List<PriceDto> data;
    PriceDto fastest;
    PriceDto bestPrice;

    public List<PriceDto> getData() {
        return data;
    }

    public void setData(List<PriceDto> data) {
        this.data = data;
    }

    public PriceDto getFastest() {
        return fastest;
    }

    public void setFastest(PriceDto fastest) {
        this.fastest = fastest;
    }

    public PriceDto getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(PriceDto bestPrice) {
        this.bestPrice = bestPrice;
    }

    public boolean isValid() {
        return data != null && !data.isEmpty() && fastest != null && bestPrice != null;
    }
}
