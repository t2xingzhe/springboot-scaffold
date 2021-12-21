package com.xing.scaffold.exception;

import com.xing.scaffold.domain.constant.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author xingzhe
 * @date 2021/12/21 20:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtensionException extends RuntimeException {

    /**
     * 业务异常码
     */
    private int code;

    /**
     * 业务异常信息
     */
    private String message;

    /**
     * cause
     */
    private Throwable cause;

    /**
     * 两个参数的构造函数
     * @param code 错误码
     * @param message 错误信息
     */
    public ExtensionException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ExtensionException(ErrorEnum errorEnum) {
        super(errorEnum.getErrMsg());
        this.code = errorEnum.getErrCode();
        this.message = errorEnum.getErrMsg();
    }
}
