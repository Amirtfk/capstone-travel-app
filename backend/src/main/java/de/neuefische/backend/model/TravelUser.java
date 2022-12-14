package de.neuefische.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("travelUser")
public class TravelUser {

    @Id
    private String username;
    private String passwordHash;
    private String email;
    private QuestionsCatalog questionsCatalog;

}
