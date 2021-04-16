package com.xing.scaffold.domain.http;

import com.xing.scaffold.domain.constant.ErrorEnum;
import lombok.Data;

/**
 * 基础返回封装
 *
 * @author xingzhe
 * @date 2021/4/7 20:38
 */
@Data
public class BaseResponse {
    /**
     * 是否成功
     */
    private Integer code;

    /**
     * 说明
     */
    private String msg;

    /**
     * 无参构造方法
     */
    public BaseResponse() {

    }

    /**
     * 全参数构造方法
     *
     * @param code code
     * @param msg  信息
     */
    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(ErrorEnum errorEnum) {
        this.code = errorEnum.getErrCode();
        this.msg = errorEnum.getErrMsg();
    }

    public <T> T result(ErrorEnum errorEnum) {
        this.code = errorEnum.getErrCode();
        this.msg = errorEnum.getErrMsg();
        return (T) this;
    }
}
