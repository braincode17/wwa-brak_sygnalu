package pl.allegro.braincode.messages.price;

import java.math.BigDecimal;

public class PriceDto {
    private int daysToSell;
    private BigDecimal price;

    public PriceDto() {
    }

    public PriceDto(int daysToSell, BigDecimal price) {
        this.daysToSell = daysToSell;
        this.price = price;
    }

    public int getDaysToSell() {
        return daysToSell;
    }

    public void setDaysToSell(int daysToSell) {
        this.daysToSell = daysToSell;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
