package com.ith.msscbeerservice.bootstrap;

import com.ith.msscbeerservice.domain.Beer;
import com.ith.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0){

            beerRepository.save(Beer.builder()
                    .beerName("LEO")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(1234567000L)
                    .price(new BigDecimal("35.25"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Change")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(1234567002L)
                    .price(new BigDecimal("50.00"))
                    .build());
        }
        log.info("Loaded Beers: "+beerRepository.count());
    }
}
