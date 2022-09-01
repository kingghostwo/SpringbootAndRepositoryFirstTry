package com.ck.vo;

import lombok.Data;

@Data
public class ResultInfo {
    private String status;
    private String message;
    private Object object;

    public ResultInfo(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ResultInfo() {
        super();
    }

    public ResultInfo(String status, String message, Object object) {
        super();
        this.status = status;
        this.message = message;
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
