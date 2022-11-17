package de.neuefische.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionCatalogDto {

    private CountryPreference countryPreference;
    private WeatherPreference weatherPreference;


}
