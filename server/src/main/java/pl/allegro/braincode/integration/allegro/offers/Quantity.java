package pl.allegro.braincode.integration.allegro.offers;

public class Quantity {
    private String unitType;
    private Integer value;

    public Quantity() {
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
