package net.rezettario.response;

import lombok.Data;
import net.rezettario.model.User;

import javax.json.bind.annotation.JsonbPropertyOrder;

@Data
@JsonbPropertyOrder({"code","userMessage","developerMessage","moreInfo","result"})
public class SingleUserResponse{

    private  int code;
    private String userMessage;
    private String developerMessage;
    private String moreInfo;
    private User result;
}
