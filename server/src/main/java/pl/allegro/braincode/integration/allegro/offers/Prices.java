package pl.allegro.braincode.integration.allegro.offers;

public class Prices {
    private Price buyNow;
    private Price current;
    private Price withDelivery;

    public Prices() {
    }

    public Price getBuyNow() {
        return buyNow;
    }

    public void setBuyNow(Price buyNow) {
        this.buyNow = buyNow;
    }

    public Price getCurrent() {
        return current;
    }

    public void setCurrent(Price current) {
        this.current = current;
    }

    public Price getWithDelivery() {
        return withDelivery;
    }

    public void setWithDelivery(Price withDelivery) {
        this.withDelivery = withDelivery;
    }
}
