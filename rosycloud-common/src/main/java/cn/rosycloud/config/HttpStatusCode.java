package cn.rosycloud.config;

public class HttpStatusCode {


    /**
     *
     */
    public static final int OK = 200;

    /**
     *
     */
    public static final int ERROR = 500;

    /**
     * token过期
     */
    public static final int TOKEN_EXPIRE = 601;

    /**
     * 用户名或密码错误
     */
    public static final int USERNAME_OR_PASSWORD_WRONG = 602;


    /**
     *  AES128加密失败
     */
    public static final int AES128_ENCRYPT_FAIL = 701;

    /**
     *  AES128解密失败
     */
    public static final int AES128_DECRYPT_FAIL = 702;

    /**
     *  AES256加密失败
     */
    public static final int AES256_ENCRYPT_FAIL = 703;

    /**
     *  AES256解密失败
     */
    public static final int AES256_DECRYPT_FAIL = 704;

    /**
     *  DES加密失败
     */
    public static final int DES_ENCRYPT_FAIL = 705;

    /**
     *  DES解密失败
     */
    public static final int DES_DECRYPT_FAIL = 706;

    /**
     *  RSA加密失败
     */
    public static final int RSA_ENCRYPT_FAIL = 707;

    /**
     *  RSA解密失败
     */
    public static final int RSA_DECRYPT_FAIL = 708;




}
