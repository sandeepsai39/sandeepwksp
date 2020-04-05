package net.rezettario.model;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Schema(description = "Food Schema")
@Data
public class Food{

    private int id;
    private String name;
    private List<String> synonyms;
    private List<String> tags;
    private String genericName;
    private NutritionFacts nutritionFacts;

}
