package br.pablo.fortnite.repositories;

import br.pablo.fortnite.models.fortnite.ShopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ShopDataRemoteRepository {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public ShopResponse getShopData() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject("https://fortnite-api.com/v2/shop/br?language=pt-BR", ShopResponse.class);

    }

}
