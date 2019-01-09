package cn.rosycloud.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * AES CBC加密
 */
public class AESOperator {
    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    private String KEY = "!QA2Z@w1sxO*(-8L";
    private String VECTOR = "!WFNZFU_{H%M(S|a";
    private static AESOperator instance = null;
    private AESOperator() { }
    public static AESOperator getInstance() {
        return Nested.instance;
    }
    //于内部静态类只会被加载一次，故该实现方式时线程安全的！
    static class Nested {
        private static AESOperator instance = new AESOperator();
    }
    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public String encrypt(String content) throws Exception {
        return encrypt(content, KEY, VECTOR);
    }
    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public String encrypt(String content,String key) throws Exception {
        return encrypt(content, key, VECTOR);
    }
    /**
     * 加密
     *
     * @param content
     * @param key
     * @param vector
     * @return
     * @throws Exception
     */
    public String encrypt(String content, String key, String vector) throws Exception {
        if (key == null) {
            return null;
        }
        if (key.length() != 16) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
         }
         /**
         * 解密
                    *
         * @param content
                    * @return
         * @throws Exception
                */
         public String decrypt(String content) throws Exception {
             return decrypt(content, KEY, VECTOR);
         }
         /**
         * 解密
         *
         * @param content
         * @return
         * @throws Exception
         */
         public String decrypt(String content,String key) throws Exception {
             return decrypt(content, key, VECTOR);
         }
         /**
         * 解密
         *
         * @param content
         * @param key
         * @param vector
         * @return
         * @throws Exception
         */
         public String decrypt(String content, String key, String vector) throws Exception {
             try {
                 if (key == null) { return null; }
                 if (key.length() != 16) { return null; }
                 SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
                 IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
                 Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                 cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
                 byte[] encrypted1 = new BASE64Decoder().decodeBuffer(content);
                 // 先用base64解密
                 byte[] original = cipher.doFinal(encrypted1);
                 String originalString = new String(original, "UTF-8");
                 return originalString;
             } catch (Exception ex) {
                 return null;
             }
         }
         public static void main(String[] args) throws Exception {
             // 需要加密的字串
             String cSrc = "我爱你";
             // 加密
             long lStart = System.currentTimeMillis();
             String enString = AESOperator.getInstance().encrypt(cSrc);
             System.out.println("加密后的字串是：" + enString);
             long lUseTime = System.currentTimeMillis() - lStart;
             System.out.println("加密耗时：" + lUseTime + "毫秒");
             // 解密
             //enString ="VxJYymMW2ayA8WCB/YTpTMX6lihK8ZvlhozqtbvRZnVnGJMcV1p76iWc3P5usF5bQffwHCwnI1Ku\\r\\ncAck3rYEfQ/3ajEWNNI9l8U/rDs9XBocRtLsucY8j9MxVx+TVH5q61HUNIJswJoTuqO9M6YtwKjZ\\r\\nObNNa1JvG3czUPq+P7mZ46+/Ic9ERd9S5s8wC6rFLusCgAzqzqpkFDcOfnX52ykavLVoi2k8oiY9\\r\\nwwUIoabnqihHaYEUDcuZlg/KzgmJhQshDKKXg/svYEF0ffd0TE1MwfrvKfuGyawnfmHHzQ63RKQI\\r\\nHBqIC0N8+QHjj6JDdjvt5lt6oiU0bG7SUzb5Md95xPb1o0j4cIG0TFYKPWTg2c3zKaxC6Q4v2eWB\\r\\nMmGKOOvnG3+wdgy3H8KP6mJl28kXK+71Q8mro292UPVpjJzz588D1aJ/Be6RjW2UDqai7PpxCdWm\\r\\nE1ZdDOineqabQ2Fdwz8n87Git+aEVuM/Dw9UWz5yc6ryMGth+OTjeMR7ZMjYPV3bmiZDfaX4bNkh\\r\\nStHIFUd/2QPZWP13VU22a5QyDjxMwqZYDJcoVm0mCmJvrKZZiGGSsg2e15Gynv5Czax9wMzcWVHj\\r\\nIUZhhqsIKcoFF91EjetrlNL75dSKumwo540PTv+0rqT9M84YmuC0PCrOwlVrO0s7QHdCU0ZykgAt\\r\\nLEqZAfjPs86ariyHf/aBi2SDMtHR6nTu+BYf2+fK+9cqmClrsEM/ULXz5aMFeTU9P1omGJ44BZEe\\r\\nfyt9j23dcVc8PAwTw0IqpQIhH6qhd3Q0p/atgeUI9qcQCMB+F9B+LLtl7WLa+2ibH2ndSU5Z";
             lStart = System.currentTimeMillis();
             String DeString = AESOperator.getInstance().decrypt(enString);
             System.out.println("解密后的字串是：" + DeString);
             lUseTime = System.currentTimeMillis() - lStart;
             System.out.println("解密耗时：" + lUseTime + "毫秒");
         }
}
