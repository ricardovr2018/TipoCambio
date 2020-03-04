package webdto.response;

import reactive.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseWebResponse {
    private ErrorCode errorCode;

    public static BaseWebResponse successNoData() {
        return BaseWebResponse.successNoData();
    }

    public static <T> BaseWebResponse successWithData(T data) {
        return BaseWebResponse.successWithData(data);
    }
    
    public static BaseWebResponse error(ErrorCode errorCode) {
        return BaseWebResponse.error(errorCode);
    }	
}
