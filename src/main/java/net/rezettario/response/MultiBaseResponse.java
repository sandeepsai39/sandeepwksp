package net.rezettario.response;

import lombok.Data;

@Data
public class MultiBaseResponse extends BaseResponse {

    private int limit;
    private int offset;
    private int total;

}
