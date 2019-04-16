package com.sinovatio.util;

/**
* @ClassName: AliPayStatusEnum
* @Description: 阿里支付服务
* @Author JinLu
* @Date 2019/4/4 10:47
* @Version 1.0
*/
public enum  AliPayStatusEnum {

    /**
     * 交易成功
     */
    FINISHED("交易成功", "TRADE_FINISHED"),

    /**
     * 支付成功
     */
    SUCCESS("支付成功", "TRADE_SUCCESS"),

    /**
     * 交易创建
     */
    BUYER_PAY("交易创建", "WAIT_BUYER_PAY"),

    /**
     * 交易关闭
     */
    CLOSED("交易关闭", "TRADE_CLOSED");

    private String name;
    private String value;

    AliPayStatusEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
