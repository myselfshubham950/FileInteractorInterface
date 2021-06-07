//package com.mercedes.aes;
//
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.Base64;
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.IvParameterSpec;
//
//public class AESEncryptDecrypt {
//
//	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
//		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//		keyGenerator.init(n);
//		SecretKey key = keyGenerator.generateKey();
//		return key;
//	}
//
//	public static IvParameterSpec generateIv() {
//	    byte[] iv = new byte[16];
//	    new SecureRandom().nextBytes(iv);
//	    return new IvParameterSpec(iv);
//	}
//	
////	public static SecretKey getKeyFromPassword(String password, String salt)
////			throws NoSuchAlgorithmException, InvalidKeySpecException {
////
////		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
////		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
////		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
////		return secret;
////	}
//
//	public static String encrypt(String input)
//			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
//			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//
//		SecretKey key = generateKey(128);
//		String algorithm = "AES/CBC/PKCS5Padding";
//		IvParameterSpec iv = generateIv();
//		Cipher cipher = Cipher.getInstance(algorithm);
//		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
//		byte[] cipherText = cipher.doFinal(input.getBytes());
//		return Base64.getEncoder().encodeToString(cipherText);
//	}
//
//	public static String decrypt(String cipherText)
//			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
//			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
//
//		SecretKey key = generateKey(128);
//		String algorithm = "AES/CBC/PKCS5Padding";
//		IvParameterSpec iv = generateIv();
//		Cipher cipher = Cipher.getInstance(algorithm);
//		cipher.init(Cipher.DECRYPT_MODE, key, iv);
//		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
//		return new String(plainText);
//	}
//}
