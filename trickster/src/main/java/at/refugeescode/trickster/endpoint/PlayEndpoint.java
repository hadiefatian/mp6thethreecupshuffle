package at.refugeescode.trickster.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/play")
public class PlayEndpoint {


    private RestTemplate restTemplate;

    public PlayEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Get request
    @GetMapping
    @Value("#{'${cup.ports}'.split(',')}")
    boolean removeCoin () {



    // Remove coin from the cups
        // Put coin in a randomly chosen cup

        // Check if coin is in that cup

    }

}
