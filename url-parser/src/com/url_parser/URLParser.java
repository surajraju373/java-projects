package com.url_parser;

import com.url_parser.utils.URLParsingHelper;
import com.url_parser.utils.InCorrectURLException;
import com.url_parser.utils.URL;

public class URLParser {

	public static void main(String...args) {
		URLParsingHelper helper = new URLParsingHelper();
		String url = "https://user1:pwd@localhost:8080/folder1/folder2/documentname?arg1=val1&arg2=val2#part123";
		URL myUrl = null;
		try {
			myUrl = helper.getResponse(url);
		} catch (InCorrectURLException e) {
			e.printStackTrace();
			System.out.println("Exception Occurred : "+e.getMessage());
		}
		
		System.out.println("Protocol : "+myUrl.getProtocol());
		System.out.println("UserName : "+myUrl.getUserName());
		System.out.println("Password : "+myUrl.getPassword());
		System.out.println("Domain : "+myUrl.getHostAddress());
		System.out.println("Port : "+myUrl.getPort());
		System.out.println("Path : "+myUrl.getPath());
		System.out.println("Args : "+myUrl.getArgsAndValues());
		System.out.println("Document part : "+myUrl.getDocumentPart());
	}
}
