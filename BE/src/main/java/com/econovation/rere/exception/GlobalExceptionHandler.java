package com.econovation.rere.exception;

import com.econovation.rere.apiresponse.ApiResult;
import com.econovation.rere.apiresponse.ApiUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.UnexpectedTypeException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ApiResult<?> handlerNullPointerException(NullPointerException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataAccessException.class)
    public ApiResult<?> handlerDataAcessException(DataAccessException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnexpectedTypeException.class)
    public ApiResult<?> handlerUnexpectedTypeException(UnexpectedTypeException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResult<?> handlerIllegalArgumentException(IllegalArgumentException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
