package net.rezettario.model;

import lombok.Data;

import java.util.List;

@Data
public class NutritionFacts {

    private int id;
    private String name;
    private String alias;
    private String category;
    private String subcategory;
    private String unit;
    private double value;
    private List<String> sources;

}
