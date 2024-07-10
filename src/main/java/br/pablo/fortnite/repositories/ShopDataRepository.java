package br.pablo.fortnite.repositories;

import br.pablo.fortnite.models.fortnite.ShopData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopDataRepository extends MongoRepository<ShopData,String> {
}
