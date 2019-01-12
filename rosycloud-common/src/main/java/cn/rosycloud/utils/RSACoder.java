package cn.rosycloud.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;

import javax.crypto.Cipher;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class RSACoder
{

	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";

	public static final String KEY_ALGORTHM = "RSA";//

	public static final String PUBLIC_KEY = "RSAPublicKey";// 公钥
	public static final String PRIVATE_KEY = "RSAPrivateKey";// 私钥

	public static final String PUBLIC_KEY_NAME = "rsa_public.key";// 公钥
	public static final String PRIVATE_KEY_NAME = "rsa_private.key";// 私钥

	public static String PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJJzWsMGoK7Rq6VgCZ4XlpHZScrimZ5PotLmZKq+kSR621NW3TLfWT4HZFJ8rAPvDLfi+1dp+hvA0nzsY4a2cR4mSk2Qp0juppvV/fp8VQMa4qPedK03wKk/j1o1Kg0QS4ZYIdRz8ZLbqcPkWIfuQwpnXoy4OEzIWkqxqmk7+7I7AgMBAAECgYBjhXCQR9i59FIot/LRNEZmJrs23HZ4VrXXjCmsvoPzvml9YPJAt/b1aCCMzZw3sCN8cwtKhAIrCgYATsPzr9d+Ffy0Xs2UDcgMYFWi6j8mfmEJoYk637Qj09TY87umT+uBJ7HEYyzaxg8uIpWiWdvts/CruiGq9CxpFrNxr5IYAQJBAM0ktlhU9y5seR1aXwH5KsUh/lndWlT/a8HZ4iinxt7n/reTDDPVD9NbPpf3zSQc8zwfrvmUfeuNmVpxH4NeVLsCQQC2wb49yFjb+oaNldbMtN5IAXCS99JOOmQebGq1tU5bl8NMNDa5gV6MpB8EV99CRa9VvsyTeYSzXtmDktGuqQCBAkEAqH+NHsS7OvByEsAV5YMJtF4Vky6TcdlSYylZ79bPLGwV9ibcEP7iPtJleWFaqFz3FN1ZVTq4qu/llDnyjm6+3QJAJenzqaWSqbBDkcPwF++93XpO/G5lNs1uT9F2IdRHOUE2xuxeHgX0s4Co3qHMM1d5lHRMxJuFKCEZRu6CiZWOAQJAEpVZvh414b7aXTbeTZymbYGc9LfvyBTYP1V/EVobPfWIFkcI3SzZid/pl8GBWkKGl0xYDGfNM+I2ezDHiUAwSA==";
	public static String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSc1rDBqCu0aulYAmeF5aR2UnK4pmeT6LS5mSqvpEkettTVt0y31k+B2RSfKwD7wy34vtXafobwNJ87GOGtnEeJkpNkKdI7qab1f36fFUDGuKj3nStN8CpP49aNSoNEEuGWCHUc/GS26nD5FiH7kMKZ16MuDhMyFpKsappO/uyOwIDAQAB";



	/**
	 * BASE64解密
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception
	{
		return org.apache.commons.codec.binary.Base64.decodeBase64(key);
	}

	/**
	 * BASE64加密
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception
	{
		return new String(Base64.encodeBase64(key), Charset.forName("utf-8"));
	}

	/**
	 * MD5加密
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception
	{
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}

	/**
	 * SHA加密
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception
	{
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}

	public static Map<String, Object> initKey() throws Exception
	{
		KeyPairGenerator keyPairGenerator = KeyPairGenerator
				.getInstance(KEY_ALGORTHM);
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// 公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		// 私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();



		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);

		//对象流形式写入公钥
		OutputStream out=new FileOutputStream(PUBLIC_KEY_NAME);
		out.write(getPublicKey(keyMap).getBytes("UTF-8"));
		out.flush();
		out.close();
		//对象流形式写入私钥
		OutputStream out1=new FileOutputStream(PRIVATE_KEY_NAME);

		out1.write(getPrivateKey(keyMap).getBytes("UTF-8"));
		out1.flush();
		out1.close();

		return keyMap;
	}



	/**
	 * 取得公钥，并转化为String类型
	 *
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap)
			throws Exception
	{
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 取得私钥，并转化为String类型
	 *
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap)
			throws Exception
	{
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 用公钥解密
	 *
	 * @param data
	 *            加密数据
	 *
	 * @param key
	 *            公钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, String key)
			throws Exception
	{
		// 对公钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取公钥
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] deBytes = null;
		int length = data.length;
		for (int i = 0; i < length; i += 128)
		{
			byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(data, i,
					i + 128));
			deBytes = ArrayUtils.addAll(deBytes, doFinal);
		}
		return deBytes;
	}

	/**
	 * 用私钥解密
	 *
	 * @param data
	 *            加密数据
	 *
	 * @param key
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, String key)
			throws Exception
	{
		// 对私钥解密
		byte[] keyBytes = decryptBASE64(key);

		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
				keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] deBytes = null;
		int length = data.length;
		for (int i = 0; i < length; i += 128)
		{
			byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(data, i,
					i + 128));
			deBytes = ArrayUtils.addAll(deBytes, doFinal);
		}
		return deBytes;
	}


	/**
	 * 用公钥加密
	 *
	 * @param data
	 *            加密数据
	 * @param key
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String key)
			throws Exception
	{
		// 对公钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取公钥
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		int length = data.length;
		byte[] enBytes = null;
		for (int i = 0; i < length; i += 64)
		{
			byte[] doFinal = cipher.doFinal(ArrayUtils
					.subarray(data, i, i + 64));
			enBytes = ArrayUtils.addAll(enBytes, doFinal);
		}
		return enBytes;
	}

	/**
	 * 用私钥加密
	 *
	 * @param data
	 *            加密数据
	 * @param key
	 *            私钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String key)
			throws Exception
	{
		// 对私钥解密

		byte[] keyBytes = decryptBASE64(key);

		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
				keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		int length = data.length;
		byte[] enBytes = null;
		for (int i = 0; i < length; i += 64)
		{
			byte[] doFinal = cipher.doFinal(ArrayUtils
					.subarray(data, i, i + 64));
			enBytes = ArrayUtils.addAll(enBytes, doFinal);
		}
		return enBytes;
	}

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



	//加密测试
	public static void main(String[] args) throws Exception
	{

		Map<String, Object> map=initKey();

		System.out.println("自动生成");
		System.out.println("公钥："+RSACoder.getPublicKey(map));
		System.out.println("私钥："+RSACoder.getPrivateKey(map));
		try
		{
			//公钥加密
			String tempString = "hello world!";
			String inString = RSACoder.encryptBASE64(encryptByPublicKey(tempString.getBytes(), PUBLICKEY));
			System.out.println(inString);
			//私钥解密
			System.out.println(new String(decryptByPrivateKey(RSACoder.decryptBASE64("U/d0miww8w89sMWZaZo2GkzLq9F7yLQ8jVMi34WC+Ii7tjKrfXbgTCmbEELr1e3bv5jqOPJNxMOBpKBwzZkVB6WyHgGT1GGBD2DVavV3EjmKEoTPrvLhrSlt5ZZX2Yh8MvRVZk2+6qHiS0uJPnseQ7sx8rdT7FwkUrRSMKaM/gE="),PRIVATEKEY)));

			//私钥加密
			tempString = "hello world!";
			inString = RSACoder.encryptBASE64(encryptByPrivateKey(tempString.getBytes(), PRIVATEKEY));
			System.out.println(inString);
			inString = "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";
			//公钥解密
			System.out.println(new String(decryptByPublicKey(RSACoder.decryptBASE64(inString),PUBLICKEY)));


			//签名
			String sign = RSA.sign("checkNumber=2150", RSACoder.PRIVATEKEY,
					"utf-8");
			System.out.println(sign);
			//校验
			Map<String,String> signmap=new HashMap<String,String>();
			signmap.put("checkNumber", "2150");
			signmap.put("sign", sign);
			System.out.println(verify(signmap));

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
