package pl.allegro.braincode.api.prices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prices")
public class PricesController {

    @GetMapping
    public Map<Integer,Long> getPrices(){
        Map<Integer,Long> prices = new HashMap<>();
        prices.put(1,3L);
        prices.put(2,3L);
        prices.put(3,30L);
        prices.put(4,35L);
        return prices;
    }
}
