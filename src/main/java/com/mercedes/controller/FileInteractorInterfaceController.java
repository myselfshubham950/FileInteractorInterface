package com.mercedes.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mercedes.model.FileInteractorInterfaceRequest;
import com.mercedes.service.FileInteractorInterfaceService;
import com.mercedes.util.Constants;

@RestController
public class FileInteractorInterfaceController {

	@Autowired
	private FileInteractorInterfaceService fileInteractorInterfaceService;
	

	@Autowired
	private Gson gson;

	public static final Logger log = LogManager.getLogger();
	
	@PostMapping("/store")
	public void storeDataInFile(@RequestBody FileInteractorInterfaceRequest request) {

		try {
			log.info("Request received to store data: "+gson.toJson(request));
			if (isValidFileType(request)) {
				fileInteractorInterfaceService.storeDataInFile(request);
			} else {
				log.info("File type is not valid");
			}
		} catch (Exception e) {
			log.error("Exception occured: "+e);
		}
	}

	@PostMapping("/update")
	public void updateDataInFile(@RequestBody FileInteractorInterfaceRequest request) {

		try {
			log.info("Request received to update data: "+gson.toJson(request));
			if (validateRequest(request)) {
				fileInteractorInterfaceService.updateDataInFile(request);
			} else {
				log.info("Request is not valid");
			}
		} catch (Exception e) {
			log.error("Exception occured: "+e);
		}
	}

	@GetMapping("/read")
	public List<FileInteractorInterfaceRequest> readDataFromFile() {

		List<FileInteractorInterfaceRequest> response = null;
		try {
			log.info("Request received to read data");
			response = fileInteractorInterfaceService.readDataFromFile();
		} catch (Exception e) {
			log.error("Exception occured: "+e);
		}
		return response;
	}

	private boolean validateRequest(FileInteractorInterfaceRequest request) {

		String fileType = request.getHeader().getFileType();
		if (StringUtils.isNotBlank(fileType)
				&& (fileType.equalsIgnoreCase(Constants.CSV) || fileType.equalsIgnoreCase(Constants.XML))) {
			if (StringUtils.isNotBlank(request.getUpdatedName()) && request.getUpdatedAge() > 0
					&& StringUtils.isNotBlank(request.getUpdatedSalary())
					&& StringUtils.isNotBlank(request.getUpdatedDob())) {
				return true;
			}
		}
		return false;
	}

	public boolean isValidFileType(FileInteractorInterfaceRequest request) {

		String fileType = request.getHeader().getFileType();
		if (StringUtils.isNotBlank(fileType)
				&& (fileType.equalsIgnoreCase(Constants.CSV) || fileType.equalsIgnoreCase(Constants.XML))) {
			return true;
		}
		return false;
	}

}
