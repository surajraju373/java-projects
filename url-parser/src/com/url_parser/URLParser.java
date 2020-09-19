package com.url_parser;

import com.url_parser.utils.URLParsingHelper;
import com.url_parser.utils.InCorrectURLException;
import com.url_parser.utils.URL;

public class URLParser {

	public static void main(String...args) {
		URLParsingHelper helper = new URLParsingHelper();
		String url = "://localhost:8080";
		URL myUrl = null;
		try {
			myUrl = helper.getResponse(url);
		} catch (InCorrectURLException e) {
			e.printStackTrace();
			System.out.println("Exception Occurred : "+e.getMessage());
		}
		
		System.out.println("Protocol : "+myUrl.getProtocol());
	}
}
