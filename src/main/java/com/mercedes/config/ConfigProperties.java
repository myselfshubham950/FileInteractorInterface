package com.mercedes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.config")
public class ConfigProperties {
	
	private String cipherKey;
	private String storeDataUrl;
	private String updateDataUrl;
	private String readDataUrl;
	
	public String getCipherKey() {
		return cipherKey;
	}

	public void setCipherKey(String cipherKey) {
		this.cipherKey = cipherKey;
	}

	public String getStoreDataUrl() {
		return storeDataUrl;
	}

	public void setStoreDataUrl(String storeDataUrl) {
		this.storeDataUrl = storeDataUrl;
	}

	public String getUpdateDataUrl() {
		return updateDataUrl;
	}

	public void setUpdateDataUrl(String updateDataUrl) {
		this.updateDataUrl = updateDataUrl;
	}

	public String getReadDataUrl() {
		return readDataUrl;
	}

	public void setReadDataUrl(String readDataUrl) {
		this.readDataUrl = readDataUrl;
	}
}
