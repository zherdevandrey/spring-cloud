package zherdev.tutorial.photoappusersservice.shared;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeinErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();
        switch (status){
            case 400:return new RuntimeException("400 status");
            case 404:return new RuntimeException("404 not found");
            default:new RuntimeException(response.reason());
        }
        return null;
    }
}
