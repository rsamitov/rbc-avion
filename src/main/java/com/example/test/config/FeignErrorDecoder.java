package com.example.test.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        try{
            return new RuntimeException(response.reason());
        }catch (final Exception ex) {
            return new RuntimeException("Exception while decoding downstream error response.", ex);
        }
    }
}
