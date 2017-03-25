package pl.allegro.braincode.integration.allegro.offers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.allegro.braincode.integration.allegro.FallbackMode;
import pl.allegro.braincode.integration.allegro.PageToken;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OffersList {
    private PageToken pageToken;
    private FallbackMode fallbackMode;
    private Integer count;
    private List<Offer> offers;
    private List<Offer> sponsoredOffers;

    public OffersList() {
    }

    public PageToken getPageToken() {
        return pageToken;
    }

    public void setPageToken(PageToken pageToken) {
        this.pageToken = pageToken;
    }

    public FallbackMode getFallbackMode() {
        return fallbackMode;
    }

    public void setFallbackMode(FallbackMode fallbackMode) {
        this.fallbackMode = fallbackMode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Offer> getSponsoredOffers() {
        return sponsoredOffers;
    }

    public void setSponsoredOffers(List<Offer> sponsoredOffers) {
        this.sponsoredOffers = sponsoredOffers;
    }
}
