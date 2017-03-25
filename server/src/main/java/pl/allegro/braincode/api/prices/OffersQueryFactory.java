package pl.allegro.braincode.api.prices;

import pl.allegro.braincode.integration.OffersQuery;
import pl.allegro.braincode.messages.category.Category;

public class OffersQueryFactory {

    public static OffersQuery from(Category category, String phrase) {
        String query;

        switch (category) {
            case CARS:
                query = ""; //TODO add query params
                break;
            case PHONES:
                query = "";
                break;
            case BICYCLES:
                query = "";
                break;
            case FURNITURE:
                query = "";
                break;
            default:
                throw new RuntimeException("Unknown category");
        }

        return new OffersQuery(query,phrase);
    }
}
