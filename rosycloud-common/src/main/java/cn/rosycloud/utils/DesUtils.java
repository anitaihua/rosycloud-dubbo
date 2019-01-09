/**
 * Filename DesUtils.java Create on 2013-5-6 Copyright 2011 zhj All Rights Reserved.
 */
package cn.rosycloud.utils;

import java.security.Key;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/**
 * Description:des加密算法
 * 
 * @author yangdaihua
 * @since version1.0
 */
public class DesUtils {

    /** 字符串默认键值 */
    private static String strDefaultKey = "national";

    /** 加密工具 */
    private Cipher        encryptCipher = null;

    /** 解密工具 */
    private Cipher        decryptCipher = null;

    public static DesUtils getInstance(){
        return new DesUtils();
    }

    /**
     *
     * @param strKey 私钥
     * @return
     */
    public static DesUtils getInstance(String strKey){
        return new DesUtils(strKey);
    }
    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[] hexStr2ByteArr(String strIn) 互为可逆的转换过程
     * 
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     */
    public static String byteArr2HexStr(byte[] arrB)  {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB) 互为可逆的转换过程
     * 
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     * @author yangdaihua
     */
    public static byte[] hexStr2ByteArr(String strIn) {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * 默认构造方法，使用默认密钥
     * 
     * @throws Exception
     */
    public DesUtils(){
        this(strDefaultKey);
    }

    /**
     * 指定密钥构造方法
     * 
     * @param strKey 指定的密钥
     * @throws Exception
     */
    @SuppressWarnings("restriction")
    public DesUtils(String strKey){
        Security.addProvider(new com.sun.crypto.provider.SunJCE());

        try {
            Key key  = getKey(strKey.getBytes());
            encryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);

            decryptCipher = Cipher.getInstance("DES");
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 加密字节数组
     * 
     * @param arrB 需加密的字节数组
     * @return 加密后的字节数组
     * @throws Exception
     */
    public byte[] encrypt(byte[] arrB)  {
        try {
            return encryptCipher.doFinal(arrB);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密字符串
     * 
     * @param strIn 需加密的字符串
     * @return 加密后的字符串
     * @throws Exception
     */
    public String encrypt(String strIn)  {
        return byteArr2HexStr(encrypt(strIn.getBytes()));
    }

    /**
     * 解密字节数组
     * 
     * @param arrB 需解密的字节数组
     * @return 解密后的字节数组
     * @throws Exception
     */
    public byte[] decrypt(byte[] arrB) {
        try {
            return decryptCipher.doFinal(arrB);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符串
     * 
     * @param strIn 需解密的字符串
     * @return 解密后的字符串
     * @throws Exception
     */
    public String decrypt(String strIn) {
        return new String(decrypt(hexStr2ByteArr(strIn)));
    }

    /**
     * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
     * 
     * @param arrBTmp 构成该字符串的字节数组
     * @return 生成的密钥
     * @throws Exception
     */
    private Key getKey(byte[] arrBTmp)  {
        // 创建一个空的8位字节数组（默认值为0）
        byte[] arrB = new byte[8];

        // 将原始字节数组转换为8位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        // 生成密钥
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

        return key;
    }

    public static void main(String[] args) {
        try {
            String test = "jackeychow2003";
            DesUtils des = new DesUtils();// 自定义密钥
            System.out.println("加密前的字符：" + test);
            System.out.println("加密后的字符：" + des.encrypt(test));
            System.out.println("解密后的字符：" + des.decrypt("87427f9b586df9cefcc14f6c1e392431912d3d587da375d2099034788a7723b3e709b6e5911d19e32f89057e429cca4df6b0517b58e865d8e5ef80796991c95757d3a442969760449fbc8d9dc703bbb6057fc212f112ad90fae385ee73c020449fbc8d9dc703bbb658049c941039fd0fc98731bc5bbd30c051ab8238722966683ea5f3ca4ce3fa2ad52119ff902ed9a760bf209f7d4ff792f60689f06d0275a59fbc8d9dc703bbb600a5044c20bca187c258f9c5a50755963cd5a4cd51d3f8ba9fbc8d9dc703bbb6d7245cc2c64f27d4a9f06bcde0042fd518bcf737e8fe01c4b10923d74fef326929f231ca4269d0668fc7c015a8abdfdcb3f7f9c095dfb89e29f231ca4269d06626ee84e601f82f3313a71a152b95a090e5ef80796991c957f19046fd0874486312456e67902f62fcce461de534d016b5d8d30e612bcb3d7045628ecae61ec882a6d3867681e610a49a38b3f97a046dbb230a4f9f8aef053e87d966c714802311e484511c5f0e96ede76cff1e8ac0a21b9334cda9db3ea41e29f231ca4269d0665a66aa37bf9303e553f93a611225d700137b0236d7f895d9d24779399b8bbd9629f231ca4269d066976dd002e18663354586a4a33bd8d875ebd17465be2713299c7816b5f0f3497751fe9db31ccba8a82a299e49f2d5d6a13ea5f3ca4ce3fa2a331b2a0317750eb23b2a995a6214550ce5ef80796991c9570ce42a7531a642b8aca8450baa071966edfdb61e1d177cfc4dc5bcee0280ca4d6a251b44dc91c4b911b4951b1460c0eb27026cc100e4e6a68ae6e0617cb7eee59bd58339bd118edac458fcf8574cfb3e1cbd5dbbdb6361914fb96591a28e3929e32625693954a9f5a939dc220b7733faa33fc1c822c142f49fbc8d9dc703bbb6ce7d4bb171d92596a8be457b8ca1dac19fbc8d9dc703bbb6e76cb709ac24badfda25b45673011c0a5f49beab1062a25f81cbbf31e143434278111bd3fe9250c390186ee678749af299a76d7699abc79295d23b6929d0fbb03ea5f3ca4ce3fa2ac189c5d7fae6eeb8494532804fa101d8db1596659549702be26295cfc77f8bb48501b696989424c45ed0eef6ba3603c89fbc8d9dc703bbb68a112b535500c86cb9b0652ba14192ff7922460a294597972ad92ffb4186c71f21206185f5ea75bbfb973edb98d2c2a71ee5d5c03675f306cbfb4e877eea469f1637dbf8adeaac5da984f29d08b00976"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
