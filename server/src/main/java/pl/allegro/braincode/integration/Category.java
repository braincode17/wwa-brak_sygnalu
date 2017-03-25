package pl.allegro.braincode.integration;

public enum Category {
    CARS("buyUsed=1&a_text_i[1][0]=1990&a_enum[16][1]=1&a_enum[13][2]=2&a_enum[12][3]=3&a_enum[128796][1]=1&a_enum[178][1]=1&order=p&category.id=4029"),
    PHONES("buyNew=1&offerTypeBuyNow=1&a_enum[1256][4]=4&category.id=48978"),
    BICYCLES("buyUsed=1&offerTypeBuyNow=1&a_enum[129291][4]=4&a_enum[129289][1024]=1024&category.id=16484"),
    FURNITURE("buyNew=1&offerTypeBuyNow=1&a_enum[18167][2]=2&category.id=54089");
    private final String baseQuery;


    Category(String query) {
        this.baseQuery=query;
    }

    public String getBaseQuery() {
        return baseQuery;
    }
}
