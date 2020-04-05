package net.rezettario.model;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "TagInfo schema")
@Data
public class TagInfo{


    private int id;
    private String name;
    private String alias;
    private String description;
    private int usedInRecipes;
    private String type;
    private String createdAt;
    private int createdBy;
}
