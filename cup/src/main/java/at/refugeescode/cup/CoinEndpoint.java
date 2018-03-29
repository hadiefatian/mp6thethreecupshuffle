package at.refugeescode.cup;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cup")
public class CoinEndpoint {

    boolean coin;

    // get
    // should be a boolean which says if it receives the coin:  yes/no
    @GetMapping
    boolean getCoin() {
        return coin;
    }

    // put
    // boolean which says now it has the coin
    @PutMapping
    boolean putCoin() {
        coin = true;
         return coin;
    }

    // delete
    // to remove the coin ( if there is already the coin )
    @DeleteMapping
    boolean removeCoin() {
        coin = false;
        return coin;
    }
}
