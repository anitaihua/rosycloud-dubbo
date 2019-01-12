package cn.rosycloud.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

@ControllerAdvice(basePackages = "cn.rosycloud")
public class MyRequestBodyAdvice implements RequestBodyAdvice {
    private final static Logger logger = LoggerFactory.getLogger(MyRequestBodyAdvice.class);
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return inputMessage;
//        try {
//            return new MyHttpInputMessage(inputMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return inputMessage;
//        }
    }
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
    class MyHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;
        private InputStream body;
        public MyHttpInputMessage(HttpInputMessage inputMessage) throws Exception {
            this.headers = inputMessage.getHeaders();
            this.body = IOUtils.toInputStream(new String(RSACoder.decryptByPrivateKey(RSACoder.decryptBASE64(IOUtils.toString(inputMessage.getBody(), "UTF-8")),RSACoder.PRIVATEKEY)), "UTF-8");
            logger.info("对方法method :" + inputMessage.getHeaders() + "返回数据进行解密");
        }
        @Override public InputStream getBody() {
            return body;
        }
        @Override public HttpHeaders getHeaders() {
            return headers;
        }
    }
}
