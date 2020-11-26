package com.training.ykb.rest.error;


public class RestException extends Exception {

    private static final long serialVersionUID = 2066617543559382166L;

    private ErrorObj          errorObj;

    public RestException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }


    public RestException() {
    }


    public ErrorObj getErrorObj() {
        return this.errorObj;
    }


    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }
}
