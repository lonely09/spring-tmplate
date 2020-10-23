package com.smec.template.exceprion;

import com.smec.template.configuration.ResponseResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        ExceptionMsg errMsg = new ExceptionMsg(status,"",ex.getMessage(),"");
        return new ResponseEntity<>(errMsg, headers, status);
    }
    @ExceptionHandler({ResourceNotFountException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseResult runtimeExceptionHandler(ResourceNotFountException exception){
        return new ResponseResult("500",false,exception.getMessage(),"");
    }
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult illegalArgumentExceptionHandler(IllegalArgumentException exception){
        return new ResponseResult("500",false,exception.getMessage(),"");
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult illegalArgumentExceptionHandler(Exception exception){
        return new ResponseResult("500",false,exception.getMessage(),"");
    }

}
