package de.neuefische.backend.repo;

import de.neuefische.backend.model.QuestionsCatalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepo extends MongoRepository<QuestionsCatalog, String> {
}
