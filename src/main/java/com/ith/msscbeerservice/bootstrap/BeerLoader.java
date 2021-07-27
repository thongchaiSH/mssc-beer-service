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

    public static  final String BEER_1_UPC="01231231";
    public static  final String BEER_2_UPC="01231232";
    public static  final String BEER_3_UPC="01231233";

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
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("35.25"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Change")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("50.00"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No name")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("70.00"))
                    .build());
        }
        log.info("Loaded Beers: "+beerRepository.count());
    }
}
