package com.training.ykb.rest.error;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Response.Body;
import feign.codec.ErrorDecoder;

public class RestErrorDecoder implements ErrorDecoder {

    @Override
    public RestException decode(final String methodKeyParam,
                                final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                Body bodyLoc = responseParam.body();
                ObjectMapper om = new ObjectMapper();
                ErrorObj readValueLoc = om.readValue(bodyLoc.asInputStream(),
                                                     ErrorObj.class);
                RestException exceptionLoc = new RestException(readValueLoc);
                return exceptionLoc;
            } else {
                RestException exceptionLoc = new RestException();
                return exceptionLoc;
            }
        } catch (Exception eLoc) {
            RestException exceptionLoc = new RestException();
            return exceptionLoc;
        }

    }

}
