
import cn.rosycloud.utils.RSA;
import cn.rosycloud.utils.RSACoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestSig {  
    
    public static boolean verify(Map<String, String> params) {
        String sign = "";
        if (params.get("sign") != null) {
            sign = params.get("sign");
        }
        boolean isSign = getSignVeryfy(params, sign);
        return isSign;
    }
            
    private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
        //过滤空值、sign与sign_type参数
        Map<String, String> sParaNew =paraFilter(Params);
        //获取待签名字符串
        String preSignStr =createLinkString(sParaNew);        
        //获得签名验证结果
        boolean isSign = false; 
        isSign = RSA.verify(preSignStr, sign, RSACoder.PUBLICKEY, "utf-8");
        return isSign;
    }
    
    
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
    
    
    public static void main(String args[]){
        
        //签名
        String sign = RSA.sign("checkNumber=2150", RSACoder.PRIVATEKEY,
               "utf-8");
        System.out.println(sign);      
        //校验 
        Map<String,String> map=new HashMap<String,String>();
        map.put("checkNumber", "2150");
        map.put("sign", sign);
        System.out.println(verify(map));
    }
    
    
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
    
    

}
