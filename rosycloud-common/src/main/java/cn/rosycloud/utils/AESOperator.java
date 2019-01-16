package cn.rosycloud.utils;

import org.apache.commons.codec.digest.DigestUtils;
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
    private String KEY = "!QA2Z@w!WFNZFU_{H%M(S|a1sxO*(-8L";
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
     * @param key
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
        if (key.length() != 32) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
        return new BASE64Encoder().encode(encrypted).replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");// 此处使用BASE64做转码。
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
                 if (key.length() != 32) { return null; }
                 SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
                 IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
                 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
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
    /**
     * 摘要处理
     *
     * @param data 待摘要数据
     * @return 摘要字符串
     */
    public static String shaHex(byte[] data) {
        return DigestUtils.md5Hex(data);
    }
    /**
     * 验证
     *
     * @param data 待摘要数据
     * @param messageDigest 摘要字符串
     * @return 验证结果
     */
    public static boolean vailidate(byte[] data, String messageDigest) {
        return messageDigest.equals(shaHex(data));
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
             enString ="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";
             String sign = "1425f8cb3d11c38e3e1c867199f283c6";
             lStart = System.currentTimeMillis();
             String DeString = AESOperator.getInstance().decrypt(enString);
             System.out.println("解密后的字串是：" + DeString);
             lUseTime = System.currentTimeMillis() - lStart;
             System.out.println("解密耗时：" + lUseTime + "毫秒");
             System.out.println("sign:"+AESOperator.shaHex(DeString.getBytes()));
            System.out.println("校验签名:" + AESOperator.vailidate(DeString.getBytes(), sign));
    }
}
