package net.rezettario.response;

import lombok.Data;
import net.rezettario.model.TagInfo;

import javax.json.bind.annotation.JsonbPropertyOrder;

@Data
@JsonbPropertyOrder({"code","userMessage","developerMessage","moreInfo","results"})
public class SingleTagResponse {

    private  int code;
    private String userMessage;
    private String developerMessage;
    private String moreInfo;
    private TagInfo result;
}
