package com.vaani.parichay.parser;

public class ImproperConfigException extends Exception{

	public ImproperConfigException(String msg){
		  super(msg);  
	}
	
	public ImproperConfigException(Exception e){
		  super(e);  
	}
}
