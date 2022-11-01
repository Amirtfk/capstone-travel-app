package de.neuefische.backend.repo;

import de.neuefische.backend.model.TravelUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface TravelUserRepo extends MongoRepository<TravelUser, String>{
    }
