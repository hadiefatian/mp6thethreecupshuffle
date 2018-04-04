package at.refugeescode.trickster.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class TricksterEndpoint {


    private RestTemplate restTemplate;
    @Value("#{'${cups.ports}'.split(',')}")
    private List<String> ports;

    public TricksterEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/play")
    void play() {
        removeTheCoinFromTheCups();
        randomlyPutTheCoinInACup();
    }

    private void removeTheCoinFromTheCups() {
        ports.stream()
                .map(port -> "http://localhost:" + port + "/cup")
                .forEach(url -> restTemplate.delete(url));
    }

    private void randomlyPutTheCoinInACup() {
        ArrayList<String> portNumbers = new ArrayList<>(ports);
        Collections.shuffle(portNumbers);
        String port = portNumbers.get(0);
        String url = "http://localhost:" + port + "/cup";
        restTemplate.put(url, null);
    }

    // choose{number} --> We type the number in the REST client
    // check if the coin is in that cup
    // --> in order to do this you need the 3 methods in cup
    @GetMapping("/choose/{number}")
    Boolean choose(@PathVariable Integer number) {
        String port = ports.get(number - 1);
        String url = "http://localhost:" + port + "/cup";
        ResponseEntity<Boolean> answer = restTemplate.getForEntity(url, Boolean.class);
        return answer.getBody();
    }
}