package cn.rosycloud.utils;

import cn.rosycloud.authorization.annotation.SerializedField;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据加密
 */
@ControllerAdvice(basePackages = "cn.rosycloud")
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    private final static Logger logger = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        boolean encode = false;
        Response r = null;
        Map<String,Object> signmap=new HashMap<String,Object>();
        if (returnType.getMethod().isAnnotationPresent(SerializedField.class)) {
            //获取注解配置的包含和去除字段
            SerializedField serializedField = returnType.getMethodAnnotation(SerializedField.class);
            //是否加密
            encode = serializedField.encode();
        }
        if (encode) {
            logger.info("对方法method :" + returnType.getMethod().getName() + "返回数据进行加密");
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
                logger.info("结果集："+result);
                if(returnType.getGenericParameterType().equals(Response.class)){
                    String sign = AESOperator.shaHex(result.getBytes());

                    r = (Response) body;
                    signmap.put("code",r.get("code"));
                    signmap.put("data", AESOperator.getInstance().encrypt(result));
                    signmap.put("sign", sign);
                    logger.info("sign："+sign);
                    return signmap;
                }
                return body;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return body;
    }
}
