package pl.allegro.braincode.integration.allegro.offers;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;
import java.util.List;

public class Offer {
    private String url;
    private Integer bidsCount;
    private Boolean auction;
    private Boolean advert;
    private Boolean buyNow;
    private String name;
    private Boolean cartAvailable;
    @JsonIgnore
    private Instant endingAt;
    private Quantity quantity;
    private Seller seller;
    private Emphases emphases;
    private Shipping shipping;
    private Prices prices;
    private List<Parameter> parameters;
    private String vendor;
    private String country;
    private Location location;
    private List<Image> images;
    private Boolean infinite;
    private String id;

    public Offer() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getBidsCount() {
        return bidsCount;
    }

    public void setBidsCount(Integer bidsCount) {
        this.bidsCount = bidsCount;
    }

    public Boolean getAuction() {
        return auction;
    }

    public void setAuction(Boolean auction) {
        this.auction = auction;
    }

    public Boolean getAdvert() {
        return advert;
    }

    public void setAdvert(Boolean advert) {
        this.advert = advert;
    }

    public Boolean getBuyNow() {
        return buyNow;
    }

    public void setBuyNow(Boolean buyNow) {
        this.buyNow = buyNow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCartAvailable() {
        return cartAvailable;
    }

    public void setCartAvailable(Boolean cartAvailable) {
        this.cartAvailable = cartAvailable;
    }

    public Instant getEndingAt() {
        return endingAt;
    }

    public void setEndingAt(Instant endingAt) {
        this.endingAt = endingAt;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Emphases getEmphases() {
        return emphases;
    }

    public void setEmphases(Emphases emphases) {
        this.emphases = emphases;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getInfinite() {
        return infinite;
    }

    public void setInfinite(Boolean infinite) {
        this.infinite = infinite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
