package com.mercedes.aes;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.mercedes.model.FileInteractorInterfaceRequest;

public class EncryptDecrypt {

	private Cipher cipher;
	private SecretKey myDesKey;

	public EncryptDecrypt(String secretkey) throws Exception {

		DESKeySpec dks = new DESKeySpec(secretkey.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		myDesKey = skf.generateSecret(dks);
		cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	}

	public String encodeBeanToString(FileInteractorInterfaceRequest request)
			throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

		String result = null;
		String jsonString = JSONUtils.toJSON(request);
		byte[] text = jsonString.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		byte[] textEncrypted = cipher.doFinal(text);
		result = Base64.encodeBase64String(textEncrypted);
		return result;
	}

	public FileInteractorInterfaceRequest decodeStringToBean(String param) throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IntrospectionException {

		byte[] decodedBytes = Base64.decodeBase64(param);
		cipher.init(Cipher.DECRYPT_MODE, myDesKey);
		byte[] textDecrypted = cipher.doFinal(decodedBytes);
		return JSONUtils.parseJSON(new String(textDecrypted), FileInteractorInterfaceRequest.class);
	}

	public List<FileInteractorInterfaceRequest> decodeStringToListOfBean(String param) throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IntrospectionException {

		byte[] decodedBytes = Base64.decodeBase64(param);
		cipher.init(Cipher.DECRYPT_MODE, myDesKey);
		byte[] textDecrypted = cipher.doFinal(decodedBytes);
		return JSONUtils.parseJSONForList(new String(textDecrypted), Object.class);
	}
}
