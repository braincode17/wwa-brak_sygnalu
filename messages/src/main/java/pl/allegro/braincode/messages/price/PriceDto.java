package pl.allegro.braincode.messages.price;

import java.math.BigDecimal;

public class PriceDto {
    int daysToSell;
    BigDecimal price;

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
