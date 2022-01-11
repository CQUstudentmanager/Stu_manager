package com.cqu.stu_manager.utils;


public enum ResultCode {

    FAIL(0, "操作失败"),
    SUCCESS(1, "操作成功");

    private final int code;
    private final String msg;

    ResultCode(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCode getApiCode(int code) {
        ResultCode[] ecs = ResultCode.values();
        for (ResultCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
