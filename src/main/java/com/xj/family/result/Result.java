/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.result;

import java.io.Serializable;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description: 统一结果封装
 todo 2023-01-19 20:27:58 move it to bean folder
 **/

public class Result implements Serializable {
    //响应码
    private Integer code;
    //信息
    private String message;
    //返回数据
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
