package cn.rosycloud.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
public class rsacsdn {

	final static String PUBLCIKEY="public-key";
	final static String PRIVATEKEY="private-key";
	final static int  MAX_DECRYPT_BLOCK=128;
	final static int  MAX_ENCRYPT_BLOCK=117;
	final static String TAG="RSA";
	final static  String SIGNATURE_ALGORITHM = "MD5withRSA";
	/**
	 * 生成公私密钥对
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static void generateKeys() throws NoSuchAlgorithmException, IOException {
		 /** RSA算法要求有一个可信任的随机数源 */
		SecureRandom secureRandom=new SecureRandom();
		 /** 为RSA算法创建一个KeyPairGenerator对象 */
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance(TAG);
		/** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
		keyPairGenerator.initialize(1024, secureRandom);
		/** 生成密匙对 */
		KeyPair keyPair=keyPairGenerator.generateKeyPair();
		/** 得到公钥 */
		java.security.Key publicKey=keyPair.getPublic();
		/** 得到私钥 */
		java.security.Key privateKey=keyPair.getPrivate();
		
		//对象流形式写入公钥
		ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(PUBLCIKEY));
	    outputStream.writeObject(publicKey);
	    outputStream.flush();
	    outputStream.close();
	    //对象流形式写入私钥
	    ObjectOutputStream outputStream1=new ObjectOutputStream(new FileOutputStream(PRIVATEKEY));
	    outputStream1.writeObject(privateKey);
	    outputStream1.flush();
	    outputStream1.close();
	}
	/**
	 * 公钥加密
	 * @param str  待加密数据
	 * @return        加密后的数据
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrypt(String str) throws ClassNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PUBLCIKEY));
		java.security.Key publicKey2= (java.security.Key)objectInputStream.readObject();
		objectInputStream.close();
		 /** 得到Cipher对象来实现对源数据的RSA加密 */
		Cipher cipher=Cipher.getInstance(TAG);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey2);
		

		byte[] encryptedData=str.getBytes();
		int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密  doFinal
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedDatas = out.toByteArray();
        out.close();
        
		return encryptedDatas;
	}
	
	/**
	 * 私钥解密
	 * @param encryString 公钥加密后的数据
	 * @return                    解密后数据
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] decrypt(byte[] encryString) throws FileNotFoundException, IOException, ClassNotFoundException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PRIVATEKEY));
		java.security.Key privatekey= (java.security.Key)objectInputStream.readObject();
		objectInputStream.close();
		
		Cipher cipher=Cipher.getInstance(TAG);
		cipher.init(Cipher.DECRYPT_MODE, privatekey);
		
		
		byte[] decryptedData=encryString;
		int inputLen = decryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(decryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(decryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedDatas = out.toByteArray();
        out.close();
		
	    return decryptedDatas;
	}
	
	//________________________________________________
	//以下为数字签名
	//所谓数字签名，就是私钥拥有者，用私钥加密数据。
	//发送往公钥拥有者，公钥拥有者用公钥验证数字签名的正确性。保证数据不被篡改和解析。
	//________________________________________________
	
	/**
	 * 数字签名
	 * @param encryptData  加密过的数据
	 * @return       私钥对信息生成数字签名
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws SignatureException
	 * @throws InvalidKeyException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static byte[] sign(byte[] encryptData) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException, FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PRIVATEKEY));
		PrivateKey privatekey3= (PrivateKey)objectInputStream.readObject();
		objectInputStream.close();
		/*
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(privatekey2.getEncoded());
		KeyFactory keyFactory=KeyFactory.getInstance(TAG);
		PrivateKey pKey=keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		*/
		Signature signature=Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privatekey3);
		signature.update(encryptData);
		byte[] result= signature.sign();
		return result;
	}
	
	
	/**
	 * 数字签名正确性验证
	 * @param encryptData  加密后的数据
	 * @param sign              数字签名
	 * @return                      数字签名验签结果（true or false）
	 * @throws SignatureException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws InvalidKeyException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static boolean verifySign(byte[] encryptData,byte[] sign) throws SignatureException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, FileNotFoundException, IOException, ClassNotFoundException
	{
		
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PUBLCIKEY));
		PublicKey publicKey2= (PublicKey)objectInputStream.readObject();
		objectInputStream.close();
		/*
		X509EncodedKeySpec keySpec=new X509EncodedKeySpec(publicKey2.getEncoded());
		KeyFactory keyFactory=KeyFactory.getInstance(TAG);
		PublicKey publicKey3= keyFactory.generatePublic(keySpec);
		*/
		Signature signature=Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey2);
		signature.update(encryptData);
		return signature.verify(sign);
	}
	
	/**
	 * 获取私钥加密后的数据
	 * @param data   待加密数据
	 * @return  私钥加密后的数据
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encryptByPrivateKey(String data) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PRIVATEKEY));
		java.security.Key privatekey= (java.security.Key)objectInputStream.readObject();
		objectInputStream.close();
		 /** 得到Cipher对象来实现对源数据的RSA加密 */
		Cipher cipher=Cipher.getInstance(TAG);
		cipher.init(Cipher.ENCRYPT_MODE, privatekey);
		

		byte[] encryptedData=data.getBytes();
		int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密  doFinal
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedDatas = out.toByteArray();
        out.close();
        
		return encryptedDatas;
	}
	
	/**
	 * 用公钥解密数据
	 * @param encryptedData  加密后的数据
	 * @return                      公钥解密后的数据
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 * @throws InvalidKeyException 
	 * @throws ClassNotFoundException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static byte[] decryptByPublicKey(byte[] encryptedData) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException
	{
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PUBLCIKEY));
		java.security.Key publicKey2= (java.security.Key)objectInputStream.readObject();
		objectInputStream.close();
		
		Cipher cipher=Cipher.getInstance(TAG);
		cipher.init(Cipher.DECRYPT_MODE, publicKey2);
		
		int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密  doFinal
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedDatas = out.toByteArray();
        out.close();
        
		return decryptedDatas;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
         String baseString="你是RSA吗？";
         System.out.println("原始字符串为:"+baseString);
         
		generateKeys();
        System.out.println("公私秘钥对生成成功...");

        System.out.println("公钥加密，私钥解密流程开始...");
		byte[] encryptByte=encrypt(baseString);
		System.out.println("加密后的密文为:"+new String( encryptByte));
        String decryptString=new String(decrypt(encryptByte));
		System.out.println("解密后的明文为："+decryptString);
		System.out.println("公钥加密，私钥解密流程结束...\r\n");
		
		 System.out.println("私钥加密，公钥解密流程开始...");
		 byte[] privateEncryptData=encryptByPrivateKey(baseString);
		 System.out.println("私钥加密后的数据为："+new String(privateEncryptData));
		 byte[] publicDecryptData=decryptByPublicKey(privateEncryptData);
		 System.out.println("公钥解密-（私钥加密后的数据）为："+new String(publicDecryptData));
		 System.out.println("私钥加密，公钥解密流程结束...\r\n");


		 System.out.println("数字签名流程开始...");
		 byte[] signresult= sign(privateEncryptData);
		 System.out.println("数字签名为:"+new String(signresult));
         boolean temp=verifySign(privateEncryptData, signresult);
         System.out.println("数字签名验签结果为:"+temp);
         System.out.println("数字签名流程结束...");
         
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
