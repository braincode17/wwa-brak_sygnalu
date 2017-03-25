package pl.allegro.braincode.api.prices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.braincode.integration.Category;
import pl.allegro.braincode.integration.OffersQuery;
import pl.allegro.braincode.messages.price.Suggestion;
import pl.allegro.braincode.price.SuggestionsService;

@RestController
@RequestMapping("/prices")
public class PriceSuggestionController {

    @Autowired
    private SuggestionsService pricesService;

    @GetMapping
    public Suggestion getSuggestion(@RequestParam Category category,
                                    @RequestParam(required = false) String phrase,
                                    @RequestParam Integer days) {
        OffersQuery offersQuery = new OffersQuery(category, phrase);
        return pricesService.getSuggestion(offersQuery, days);
    }
}
