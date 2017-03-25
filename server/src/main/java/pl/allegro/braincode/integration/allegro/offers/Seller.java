package pl.allegro.braincode.integration.allegro.offers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {
    private Long id;
    private Boolean allegroStandard;
    private Boolean brandZone;

    public Seller() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAllegroStandard() {
        return allegroStandard;
    }

    public void setAllegroStandard(Boolean allegroStandard) {
        this.allegroStandard = allegroStandard;
    }

    public Boolean getBrandZone() {
        return brandZone;
    }

    public void setBrandZone(Boolean brandZone) {
        this.brandZone = brandZone;
    }
}
