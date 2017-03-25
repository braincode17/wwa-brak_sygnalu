package pl.allegro.braincode.integration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OffersQuery {
    private String queryParams;
    private String phrase;

    public OffersQuery(Category category, String phrase) {
        this.queryParams = category.getBaseQuery();
        this.phrase = phrase;
    }

    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        Arrays.asList(queryParams.split("&"))
                .stream()
                .forEach(s -> {
                    String[] kv = s.split("=");
                    params.put(kv[0], kv[1]);
                });
        params.put("country.code", "PL");

        //TODO hack ;p
        if (phrase == null) {
            phrase="a";
        }
        params.put("phrase", phrase);
        return params;
    }
}
