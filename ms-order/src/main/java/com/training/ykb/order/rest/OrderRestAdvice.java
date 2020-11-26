package com.training.ykb.order.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.ykb.rest.error.ErrorObj;
import com.training.ykb.rest.error.RestException;

@RestControllerAdvice
public class OrderRestAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        List<ObjectError> allErrorsLoc = exp.getBindingResult()
                                            .getAllErrors();
        ErrorObj validationErrorObjLoc = new ErrorObj().setDomain("Restaurant")
                                                       .setSubDomain("OrderManagement")
                                                       .setBoundedContext("Order")
                                                       .setMicroservice("Order")
                                                       .setErrorDesc("Validation Error oluştu")
                                                       .setCause(101);
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            validationErrorObjLoc.addSubErrors(new ErrorObj().setDomain("Restaurant")
                                                             .setSubDomain("OrderManagement")
                                                             .setBoundedContext("Order")
                                                             .setMicroservice("Order")
                                                             .setErrorDesc("" + objectErrorLoc)
                                                             .setCause(107));
        }
        return validationErrorObjLoc;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return new ErrorObj().setDomain("Restaurant")
                             .setSubDomain("OrderManagement")
                             .setBoundedContext("Order")
                             .setMicroservice("Order")
                             .setErrorDesc(exp.getMessage())
                             .setCause(101);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(final NullPointerException exp) {
        return new ErrorObj().setDomain("Restaurant")
                             .setSubDomain("OrderManagement")
                             .setBoundedContext("Order")
                             .setMicroservice("Order")
                             .setErrorDesc(exp.getMessage())
                             .setCause(102);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(final Exception exp) {
        return new ErrorObj().setDomain("Restaurant")
                             .setSubDomain("OrderManagement")
                             .setBoundedContext("Order")
                             .setMicroservice("Order")
                             .setErrorDesc(exp.getMessage())
                             .setCause(105);

    }

    @ExceptionHandler(RestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final RestException exp) {
        ErrorObj rootErrorObjLoc = new ErrorObj().setDomain("Restaurant")
                                                 .setSubDomain("OrderManagement")
                                                 .setBoundedContext("Order")
                                                 .setMicroservice("Order")
                                                 .setErrorDesc(exp.getMessage())
                                                 .setCause(105);
        rootErrorObjLoc.addSubErrors(exp.getErrorObj());
        return rootErrorObjLoc;

    }


}
