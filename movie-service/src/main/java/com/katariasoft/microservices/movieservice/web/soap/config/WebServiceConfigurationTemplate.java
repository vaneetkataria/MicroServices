package com.katariasoft.microservices.movieservice.web.soap.config;

public class WebServiceConfigurationTemplate {

	public String rootNode;
	public String jaxbPackage;
	public String uri;
	public String fetchDummyResponse;
	public String fileName;
	public boolean logXml;
	public String soapActionHeaderUri;

	public String getRootNode() {
		return rootNode;
	}

	public void setRootNode(String rootNode) {
		this.rootNode = rootNode;
	}

	public String getJaxbPackage() {
		return jaxbPackage;
	}

	public void setJaxbPackage(String jaxbPackage) {
		this.jaxbPackage = jaxbPackage;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFetchDummyResponse() {
		return fetchDummyResponse;
	}

	public void setFetchDummyResponse(String fetchDummyResponse) {
		this.fetchDummyResponse = fetchDummyResponse;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isLogXml() {
		return logXml;
	}

	public void setLogXml(boolean logXml) {
		this.logXml = logXml;
	}

	public String getSoapActionHeaderUri() {
		return soapActionHeaderUri;
	}

	public void setSoapActionHeaderUri(String soapActionHeaderUri) {
		this.soapActionHeaderUri = soapActionHeaderUri;
	}

}
