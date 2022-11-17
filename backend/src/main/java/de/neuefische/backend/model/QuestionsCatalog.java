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
@Document("capstone-travel-db")
public class QuestionsCatalog {

    @Id
    private String username;
    private CountryPreference countryPreference;
    private WeatherPreference weatherPreference;
    private UserPreference userPreferences;

}
