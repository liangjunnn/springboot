package com.lj.exception;

import com.lj.common.enums.ErrorMsgEnum;

/**
 * @author : liangjun
 * @ClassName : CustomException
 * @Description : 自定义异常
 * @Date : 2019/11/22 13:59
 */
public class CustomException extends RuntimeException {


    private static final long serialVersionUID = 3482226533386781366L;

    private ErrorMsgEnum code;

    public CustomException(ErrorMsgEnum code) {
        super(code.getMsg());
        this.code = code;
    }

    public CustomException(ErrorMsgEnum code, Object... args) {
        super(ErrorMsgEnum.getMsg(code, args));
        this.code = code;
    }

    public CustomException(ErrorMsgEnum code, Throwable t) {
        super(code.getMsg(), t);
        this.code = code;
    }

    public ErrorMsgEnum getErrorMsgEnum() {
        return code;
    }

    @Override
    public String toString() {
        if (null != code) {
            String format = String.format("%s : %s", code.getCode(), super.getMessage());
            return format;
        }
        return "";
    }
}
