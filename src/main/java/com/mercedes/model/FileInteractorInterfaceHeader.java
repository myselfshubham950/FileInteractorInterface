package com.mercedes.model;

import javax.validation.constraints.NotNull;

public class FileInteractorInterfaceHeader {
	
	@NotNull
	private String transId;
	private String fileType;
	
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}
