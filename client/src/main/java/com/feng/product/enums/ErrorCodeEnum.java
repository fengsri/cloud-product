package com.feng.product.enums;

import lombok.Getter;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/7 17:45
 * @Version V1.0
 */
@Getter
public enum ErrorCodeEnum {


    SUCCESS("0000", "请求成功"),

    ERROR("401", "未知错误"),


    PAREM_ERROR("301", "参数为空"),

    NOT_EXIST_PRODUCT_ERROR("302", "不存在商品"),

    REDUCE_COUNT_ERROR("303","减库存失败"),

    PRODUCT_COUNT_ERROR("302","商品数量不足")
    ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
