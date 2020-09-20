package com.url_parser.utils;

import java.util.HashMap;

public class URLParsingHelper {

	public URL getResponse(String url) throws InCorrectURLException {

		String protocol = null;
		String userName = null;
		String password = null;
		String domain = null;
		String port = null;
		String path = null;
		HashMap<String, String> args = new HashMap<>();
		String documentPart = null;
		int i, start = 0;
		for (i = start; url.charAt(i) != '/'; i++) {
			char c = url.charAt(i);
			if (c == ':') {
				String s = url.substring(start, i);
				if (isValidProtocol(s)) {
					protocol = s;
					start = i + 1;
					break;
				}
			}
		}
		start += 2;
		for (i = start; url.charAt(i - 1) != '@'; i++) {
			if (url.charAt(i) == '@') {
				String s = url.substring(start, i);
				if (isValidUserNameAndPassword(s)) {
					String[] upd = getUNAndPwd(s);
					userName = upd[0];
					password = upd[1];
					start = i + 1;
					break;
				}
			}
		}

		for (i = start; url.charAt(i - 1) != ':'; i++) {
			if (url.charAt(i) == ':') {
				String s = url.substring(start, i);
				if (isValidDomain(s)) {
					domain = s;
					start = i + 1;
					break;
				}
			}
		}

		for (i = start; url.charAt(i - 1) != '/'; i++) {
			if (url.charAt(i) == '/') {
				String s = url.substring(start, i);
				if (isValidPort(s)) {
					port = s;
					start = i + 1;
					break;
				}
			}
		}

		for (i = start; url.charAt(i - 1) != '?'; i++) {
			if (url.charAt(i) == '?') {
				String s = url.substring(start, i);
				if (isValidPath(s)) {
					path = s;
					start = i + 1;
					break;
				}
			}
		}

		for (i = start; url.charAt(i - 1) != '#'; i++) {
			if (url.charAt(i) == '#') {
				String s = url.substring(start, i);
				args = getArgsFromString(s);
				start = i + 1;
				break;
			}
		}

		documentPart = url.substring(start, url.length());

		return new URL.URLBuilder().setProtocol(protocol).setUserName(userName).setPassword(password)
				.setHostAddress(domain).setPort(port).setPath(path).setArgsAndValues(args).setDocumentPart(documentPart)
				.build();
	}

	private boolean isValidProtocol(String protocol) throws InCorrectURLException {
		if (protocol.isEmpty()) {
			throw new InCorrectURLException("Invalid protocol detected");
		}
		return true;
	}

	private boolean isValidUserNameAndPassword(String uAndPwd) throws InCorrectURLException {
		if (!(uAndPwd.split(":").length == 2)) {
			throw new InCorrectURLException("Invalid username or password detected");
		}
		return true;
	}

	private boolean isValidDomain(String domain) throws InCorrectURLException {
		if (domain.isEmpty()) {
			throw new InCorrectURLException("Invalid domain detected");
		}
		return true;
	}

	private boolean isValidPort(String port) throws InCorrectURLException {
		if (port.isEmpty()) {
			throw new InCorrectURLException("Invalid port detected");
		}
		return true;
	}

	private boolean isValidPath(String path) throws InCorrectURLException {
		if (path.isEmpty()) {
			throw new InCorrectURLException("Invalid path detected");
		}
		return true;
	}

	private String[] getUNAndPwd(String uAndPwd) {
		return uAndPwd.split(":");
	}

	private HashMap<String, String> getArgsFromString(String s) {
		HashMap<String, String> map = new HashMap<>();
		String[] pairs = s.split("&");
		for (int i = 0; i < pairs.length; i++) {
			String[] kv = pairs[i].split("=");
			String key = kv[0];
			String value = kv[1];
			map.put(key, value);
		}
		return map;
	}
}
