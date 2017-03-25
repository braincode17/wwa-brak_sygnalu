package pl.allegro.braincode.integration;

public enum Category {
    CARS("buyUsed=1&a_text_i[1][0]=2005&a_enum[16][1]=1&a_enum[13][2]=2&a_enum[12][3]=3&a_enum[128796][1]=1&a_enum[178][1]=1&order=p&category.id=4029"),
    PHONES(""),
    BICYCLES(""),
    FURNITURE("");

    private final String baseQuery;


    Category(String query) {
        this.baseQuery=query;
    }

    public String getBaseQuery() {
        return baseQuery;
    }
}
