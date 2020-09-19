package com.url_parser.utils;

public class URLParsingHelper {

	public URL getResponse(String url) throws InCorrectURLException {
		
		String protocol = null;
		int i, start=0;
		for(i=start; url.charAt(i)!='/'; i++) {
			char c = url.charAt(i);
			if(c == ':') {
				String s = url.substring(start,i);
				if(isValidProtocol(s)) {
					protocol = s;
					start = i+1;
					break;
				}
			}
		}
		return new URL.URLBuilder().setProtocol(protocol).build();
	}
	
	private boolean isValidProtocol(String protocol) throws InCorrectURLException {
		if(protocol.isEmpty()) {
			throw new InCorrectURLException("Invalid protocol detected");
		}
		return true;
	}
}
