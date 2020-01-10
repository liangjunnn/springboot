package com.lj.exception;

import com.lj.common.enums.ErrorMsgEnum;

/**
 * @author : liangjun
 * @ClassName : UserException
 * @Description :
 * @Date : 2019/11/22 14:10
 */
public class UserException extends CustomException {
    private static final long serialVersionUID = -9206345613481107596L;

    public UserException(ErrorMsgEnum code) {
        super(code);
    }

    public UserException(ErrorMsgEnum code, Object... args) {
        super(code, args);
    }

    public UserException(ErrorMsgEnum code, Throwable t) {
        super(code, t);
    }
}
