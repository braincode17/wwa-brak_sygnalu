package pl.allegro.braincode.integration.allegro.offers;

public class Price {
    private Double amount;
    private String currency;

    public Price() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
