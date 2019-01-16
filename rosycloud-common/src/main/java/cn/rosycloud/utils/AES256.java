package cn.rosycloud.utils;



import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * This class used to perform AES encryption and decryption.
 */
public class AES256 {

    private String KEY = "!QA2Z@w!WFNZFU_{H%M(S|a1sxO*(-8L";
    private String VECTOR = "!WFNZFU_{H%M(S|a";


    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
    private static final int PBKDF2_ITERATION_COUNT = 1001;
    private static final int PBKDF2_KEY_LENGTH = 256;
    private static final int SECURE_IV_LENGTH = 64;
    private static final int SECURE_KEY_LENGTH = 128;
    private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final String PBKDF2_SALT = "hY0wTq6xwc6ni01G";
    private static final Random RANDOM = new SecureRandom();


    private AES256(){

    }

    public static AES256 getInstance(){
        return  Nested.instance;
    }

    //于内部静态类只会被加载一次，故该实现方式时线程安全的！
    static class Nested{
        private static AES256 instance = new AES256();
    }

    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public String encrypt(String content) throws Exception {
        return encrypt(KEY,content, VECTOR);
    }

    /**
     * 解密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public String decrypt(String content) throws Exception {
        return decrypt(KEY, content, VECTOR);
    }

    /**
     * <p>
     * To perform the AES256 encryption
     * </p>
     *
     * @param secureKey A 32 bytes string, which will used as input key for AES256 encryption
     * @param value     A string which will be encrypted
     * @param iv        A 16 bytes string, which will used as initial vector for AES256 encryption
     * @return AES Encrypted string
     * @throws Exception
     */
    private String encrypt(String secureKey, String value, String iv) throws Exception {
        byte[] pbkdf2SecuredKey = generatePBKDF2(secureKey.toCharArray(), PBKDF2_SALT.getBytes("UTF-8"),
                PBKDF2_ITERATION_COUNT, PBKDF2_KEY_LENGTH);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(pbkdf2SecuredKey, "AES");

        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encrypted = cipher.doFinal(value.getBytes());

        return Base64.encodeToString(encrypted, Base64.DEFAULT).replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");

    }

    /**
     * <p>
     * To perform the AES256 decryption
     * </p>
     *
     * @param secureKey A 32 bytes string, which will used as input key for AES256 decryption
     * @param value     A 16 bytes string, which will used as initial vector for AES256 decryption
     * @param iv        An AES256 encrypted data which will be decrypted
     * @return AES Decrypted string
     * @throws Exception
     */
    private String decrypt(String secureKey, String value, String iv) throws Exception {
        byte[] pbkdf2SecuredKey = generatePBKDF2(secureKey.toCharArray(), PBKDF2_SALT.getBytes("UTF-8"),
                PBKDF2_ITERATION_COUNT, PBKDF2_KEY_LENGTH);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(pbkdf2SecuredKey, "AES");

        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] original = cipher.doFinal(Base64.decode(value, Base64.DEFAULT));

        return new String(original);
    }

    /**
     * @param password       The password
     * @param salt           The salt
     * @param iterationCount The iteration count
     * @param keyLength      The length of the derived key.
     * @return PBKDF2 secured key
     * @throws Exception
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/PBEKeySpec.html">
     * https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/PBEKeySpec.html</a>
     */
    private static byte[] generatePBKDF2(char[] password, byte[] salt, int iterationCount,
                                         int keyLength) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        KeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
        return secretKey.getEncoded();
    }

    /**
     * <p>
     * This method used to generate the secure key based on the PBKDF2 algorithm
     * </p>
     *
     * @param password The password
     * @return SecureKey
     * @throws Exception
     */
    private static String generateSecureKey(String password) throws Exception {
        byte[] secureKeyInBytes = generatePBKDF2(password.toCharArray(), generateRandomSalt(),
                PBKDF2_ITERATION_COUNT, SECURE_KEY_LENGTH);
        return Hex.encodeHexString(secureKeyInBytes);
    }

    /**
     * <p>
     * This method used to generate the secure IV based on the PBKDF2 algorithm
     * </p>
     *
     * @param password The password
     * @return SecureIV
     * @throws Exception
     */
    private static String generateSecureIV(String password) throws Exception {
        byte[] secureIVInBytes = generatePBKDF2(password.toCharArray(), generateRandomSalt(),
                PBKDF2_ITERATION_COUNT, SECURE_IV_LENGTH);
        return Hex.encodeHexString(secureIVInBytes);
    }

    /**
     * <p>
     * This method used to generate the random salt
     * </p>
     *
     * @return
     */
    private static byte[] generateRandomSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }


    public static void main(String[] args) throws Exception {

        // 需要加密的字串
        String cSrc = "我爱你";

        String enString = AES256.getInstance().encrypt(cSrc);

        System.out.println("加密后的字串是：" + enString);

        String DeString = AES256.getInstance().decrypt(enString);

        System.out.println("解密后的字串是：" + DeString);

        System.out.println("KEY:"+AES256.getInstance().generateSecureKey("123456"));

        System.out.println("IV:"+AES256.getInstance().generateSecureIV("123456"));

    }
}