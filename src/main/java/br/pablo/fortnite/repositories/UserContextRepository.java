package br.pablo.fortnite.repositories;

import br.pablo.fortnite.models.UserContext;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserContextRepository extends MongoRepository<UserContext,String> {
}
