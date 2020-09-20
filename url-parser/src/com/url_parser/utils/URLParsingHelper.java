package com.url_parser.utils;

public class URLParsingHelper {

	public URL getResponse(String url) throws InCorrectURLException {

		String protocol = null;
		String userName = null;
		String password = null;
		String domain = null;
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

		return new URL.URLBuilder().setProtocol(protocol).setUserName(userName).setPassword(password)
				.setHostAddress(domain).build();
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

	private String[] getUNAndPwd(String uAndPwd) {
		return uAndPwd.split(":");
	}
}
