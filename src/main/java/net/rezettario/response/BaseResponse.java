package net.rezettario.response;

import lombok.Data;

@Data
public class BaseResponse {

    private  int code;
    private String userMessage;
    private String developerMessage;
    private String moreInfo;
}
