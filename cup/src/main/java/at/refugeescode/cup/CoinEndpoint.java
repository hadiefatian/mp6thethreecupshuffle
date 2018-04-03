package at.refugeescode.cup;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cup")
public class CoinEndpoint {

    private Boolean coin;

    // A boolean which says if it receives the coin:  yes/no
    @GetMapping
    Boolean getCoin() {
        return coin;
    }

    // Boolean which says now it has the coin
    @PutMapping
    void putCoin() {
        coin = true;
    }

    // Remove the coin ( if there is already the coin )
    @DeleteMapping
    void removeCoin() {
        coin = false;
    }
}
