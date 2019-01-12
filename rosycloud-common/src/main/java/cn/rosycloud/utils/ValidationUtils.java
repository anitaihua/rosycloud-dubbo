package cn.rosycloud.utils;

import org.springframework.validation.FieldError;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class ValidationUtils {

    private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("messages");

    /**
     * 获取配置文件参数
     *
     * @param name
     * @return
     */
    public static final String getConfigByName(String name) {
        try {
            return new String(bundle.getString(name).getBytes("ISO-8859-1"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  bundle.getString(name);
    }

    /**
     * 获取messages配置文件信息
     *
     * @param fieldError
     * @return
     */
    public static String getDefaultMessage(FieldError fieldError) {
        String defaultMessage =fieldError.getDefaultMessage().replace("{","").replace("}","");
        return fieldError.getField()+":"+ getConfigByName(defaultMessage);
    }
}
