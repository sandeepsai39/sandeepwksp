package net.rezettario.response;

import lombok.Data;
import net.rezettario.model.TagInfo;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.util.List;

@Data
@JsonbPropertyOrder({"code","userMessage","developerMessage","moreInfo","limit","offset","total","results"})
public class TagsResponse {

    private  int code;
    private String userMessage;
    private String developerMessage;
    private String moreInfo;
    private int limit;
    private int offset;
    private int total;
    private List<TagInfo> results;
}
