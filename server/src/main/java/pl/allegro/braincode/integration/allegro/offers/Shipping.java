package pl.allegro.braincode.integration.allegro.offers;

public class Shipping {
    private Price lowestShippingCost;
    private Boolean free;
    private Boolean freeReturn;

    public Price getLowestShippingCost() {
        return lowestShippingCost;
    }

    public void setLowestShippingCost(Price lowestShippingCost) {
        this.lowestShippingCost = lowestShippingCost;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Boolean getFreeReturn() {
        return freeReturn;
    }

    public void setFreeReturn(Boolean freeReturn) {
        this.freeReturn = freeReturn;
    }
}
