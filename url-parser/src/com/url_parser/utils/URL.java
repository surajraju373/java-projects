package com.url_parser.utils;

import java.util.HashMap;

public class URL {

	private String protocol;
	private String userName;
	private String password;
	private String hostAddress;
	private String port;
	private String path;
	private HashMap<String, String> argsAndValues;
	private String documentPart;
	
	public String getProtocol() {
		return protocol;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public String getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public HashMap<String, String> getArgsAndValues() {
		return argsAndValues;
	}

	public String getDocumentPart() {
		return documentPart;
	}

	private URL(URLBuilder urlBuilder) {
		this.protocol = urlBuilder.protocol;
		this.userName = urlBuilder.userName;
		this.password = urlBuilder.password;
		this.hostAddress = urlBuilder.hostAddress;
		this.port = urlBuilder.port;
		this.path = urlBuilder.path;
		this.argsAndValues = urlBuilder.argsAndValues;
		this.documentPart = urlBuilder.documentPart;
	}

	public static class URLBuilder {
		private String protocol;
		private String userName;
		private String password;
		private String hostAddress;
		private String port;
		private String path;
		private HashMap<String, String> argsAndValues;
		private String documentPart;

		public URLBuilder setProtocol(String protocol) {
			this.protocol = protocol;
			return this;
		}

		public URLBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public String getPassword() {
			return password;
		}

		public URLBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public URLBuilder setHostAddress(String hostAddress) {
			this.hostAddress = hostAddress;
			return this;
		}

		public URLBuilder setPort(String port) {
			this.port = port;
			return this;
		}

		public URLBuilder setPath(String path) {
			this.path = path;
			return this;
		}

		public URLBuilder setArgsAndValues(HashMap<String, String> argsAndValues) {
			this.argsAndValues = argsAndValues;
			return this;
		}

		public URLBuilder setDocumentPart(String documentPart) {
			this.documentPart = documentPart;
			return this;
		}

		public URL build() {
			return new URL(this);
		}
	}
}
