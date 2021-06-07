package com.mercedes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mercedes.aes.EncryptDecrypt;
import com.mercedes.model.FileInteractorInterfaceRequest;
import com.mercedes.config.ConfigProperties;

@Service
public class FileInteractorInterfaceService {
	
	@Autowired
	ConfigProperties configProperties;

	
	public void storeDataInFile(FileInteractorInterfaceRequest request) throws Exception {

		EncryptDecrypt encryptDecrypt = new EncryptDecrypt(configProperties.getCipherKey());
		String encodedRequest = encryptDecrypt.encodeBeanToString(request);
		RestTemplate rt = new RestTemplate();
		rt.postForObject(configProperties.getStoreDataUrl(), encodedRequest, Object.class);
		
	}

	public void updateDataInFile(FileInteractorInterfaceRequest request) throws Exception {
		
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt(configProperties.getCipherKey());
		String encodedRequest = encryptDecrypt.encodeBeanToString(request);
		RestTemplate rt = new RestTemplate();
		rt.postForObject(configProperties.getUpdateDataUrl(), encodedRequest, Object.class);

	}

	public List<FileInteractorInterfaceRequest> readDataFromFile() throws Exception {

		RestTemplate rt = new RestTemplate();
		String encrytedResponse =  rt.getForObject(configProperties.getReadDataUrl(), String.class);
		EncryptDecrypt encryptDecrypt = new EncryptDecrypt(configProperties.getCipherKey());
		List<FileInteractorInterfaceRequest> response = encryptDecrypt.decodeStringToListOfBean(encrytedResponse);
		return response;
	}

}
