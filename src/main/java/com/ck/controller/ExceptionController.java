package com.ck.controller;

import com.ck.vo.ResultInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = AuthorizationException.class)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ResponseBody
    public ResultInfo handlerAccessDeniedException(HttpServletRequest request,
                                                   AuthorizationException e){
        return new ResultInfo("500", "noPermission");
    }

}
