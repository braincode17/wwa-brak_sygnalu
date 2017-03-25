package pl.allegro.braincode.integration;

import org.junit.Test;

public class OffersQueryTest {

    @Test
    public void shouldParseQuery() throws Exception{
        OffersQuery offersQuery = new OffersQuery(Category.PHONES,"iphone");
        System.out.println(offersQuery.getQueryParams().toString());
    }

}