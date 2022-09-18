package com.ck.spring_boot_try.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int status;
    private String message;
    private T object;

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }


    public enum ResultStatus{
        SUCCESS(200),FAILED(500);
        public int status;
        private ResultStatus(int status){
            this.status = status;
        }
    }
}
