package com.xing.scaffold.exception;

import com.xing.scaffold.domain.constant.ErrorEnum;
import com.xing.scaffold.domain.http.BaseResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用异常捕获类
 *
 * @author maguoliang
 * 2020年5月12日 下午3:45:26
 */
@RestControllerAdvice(basePackages = {"com.xing"})
public class GlobalExceptionHandler {

    Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    /**
     * 针对参数校验失败异常的处理
     *
     * @param exception 参数校验异常
     * @param request   http request
     * @param response  http response
     * @return 异常处理结果
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class,
            IllegalArgumentException.class})
    public BaseResponse dataBindException(Exception exception,
                                          HttpServletRequest request, HttpServletResponse response) {
        BaseResponse result = new BaseResponse();

        if (exception instanceof BindException) {
            StringBuilder sb = new StringBuilder();
            ((BindException) exception).getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                sb.append("[").append(fieldName).append("]").append(error.getDefaultMessage()).append("; ");
            });
            result.setCode(ErrorEnum.PARAM_ERROR.getErrCode());
            result.setMsg(sb.toString());
        } else if (exception instanceof IllegalArgumentException) {
            logger.error("IllegalArgumentException", exception);
            result.result(ErrorEnum.COMMON_ERROR);
        }
        return result;
    }

    /**
     * 针对全局异常的处理
     *
     * @param exception 全局异常
     * @param request   http request
     * @param response  http response
     * @return 异常处理结果
     */
    @ExceptionHandler(value = Throwable.class)
    public BaseResponse throwableHandler(Exception exception,
                                         HttpServletRequest request, HttpServletResponse response) {
        logger.error("系统内部异常！", exception);
        return new BaseResponse(ErrorEnum.COMMON_ERROR.getErrCode(),
                ErrorEnum.COMMON_ERROR.getErrMsg());
    }
}


