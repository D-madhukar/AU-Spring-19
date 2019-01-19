/**
 * 
 */
package com.servletapplication.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Madhukar
 *
 */
public class ServletApplicationLogger {
	
	public static final String TYPE_REQUEST="Request-Info";
	public static final String TYPE_SESSION="Session-Info";
	public static final String TYPE_SERVER="Server-Info";
	public static final String TYPE_DATABASE="Database-Info";
	public static final String LOG_FORMAT="%s\t\t%s\t%s";
	static PrintWriter logWriter=null;
	public ServletApplicationLogger(String logFilePath){
		try {
			//FileWriter in append model
			FileWriter fw=new FileWriter(logFilePath,true);
			BufferedWriter bw=new BufferedWriter(fw);
			logWriter=new PrintWriter(bw);
		}
		catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	public static void log(String type,String message) {
		logWriter.format(LOG_FORMAT,new Date().toString(),type,message);
		logWriter.println();
		logWriter.flush();
	}
	
}
