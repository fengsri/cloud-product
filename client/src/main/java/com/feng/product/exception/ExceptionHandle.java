package com.feng.product.exception;

import com.feng.product.enums.ErrorCodeEnum;
import com.feng.product.util.ResultUtil;
import com.feng.product.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 全局异常处理器
 * @Author chenlinghong
 * @Date 2019/4/21 21:17
 * @Version V1.0
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handle(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException baseException = (BusinessException) e;
            return ResultUtil.error(baseException.getCode(), baseException.getMessage());
        } else {
            log.error("【系统异常】{}", e);
            return ResultUtil.error(ErrorCodeEnum.ERROR);
        }
    }
}
