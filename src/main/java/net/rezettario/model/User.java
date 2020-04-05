package net.rezettario.model;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "User Schema")
@Data
public class User{

    private int id;
    private String firstname;
    private String Lastname;
    private String alias;
    private String profileImagePath;
    private String createdAt;
    private int createdBy;

}
