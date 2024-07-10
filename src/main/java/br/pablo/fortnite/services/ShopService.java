package br.pablo.fortnite.services;

import br.pablo.fortnite.models.fortnite.ShopData;
import br.pablo.fortnite.repositories.ShopDataRemoteRepository;
import br.pablo.fortnite.repositories.ShopDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopDataRepository shopDataRepository;

    @Autowired
    private ShopDataRemoteRepository shopDataRemoteRepository;

    public ShopData getShopData() {
        Instant now = Instant.now();
        String nowString = now.toString();
        Optional<ShopData> shopData = shopDataRepository.findById(nowString);
        return shopData.orElseGet(() -> shopDataRepository.save(shopDataRemoteRepository.getShopData().getData()));
    }

}
