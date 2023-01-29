package com.resshare.clienst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.resshare.springboot.StartServiceListenerCore;

/**
 * This example shows how to upload files using POST requests with encryption
 * type "multipart/form-data". For more details please read the full tutorial on
 * https://javatutorial.net/java-file-upload-rest-service
 * 
 * @author javatutorial.net
 */
public class FileUploaderClient {

	public static void main(String[] args) {

		buildUIScript();

	}

	public static void buildUIScript() {
		Properties propuiconfig = StartServiceListenerCore.getConfig("uiconfig.properties");
		Set<Object> key = propuiconfig.keySet();
		boolean update = false;
		for (Iterator iterator = key.iterator(); iterator.hasNext();) {
			String filePath = (String) iterator.next();
			Object dateUdatfile = propuiconfig.get(filePath);
			long lastModifiedOld = Long.parseLong(dateUdatfile.toString());

			File inFile = new File(filePath);
			if (inFile.exists()) {
				long lastModified = inFile.getAbsoluteFile().lastModified();
				if (lastModified != lastModifiedOld) {

					if (buildUI(inFile)) {
						propuiconfig.setProperty(filePath, String.valueOf(lastModified));
						update = true;
					}

				}
			}

		}
		if (update) {
			try {
				OutputStream output = new FileOutputStream("uiconfig.properties");

				propuiconfig.store(output, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// the file we want to upload
		// File inFile = new
		// File("com/resshare/covid19/uiscript/CreateVolunteersGroupListenerUI.java");
	}

	private static boolean buildUI(File inFile) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inFile);
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

			String uid = StartServiceListenerCore.USER_ID;
			
			String app_name =StartServiceListenerCore.APPLICATION_NAME;
			// server back-end URL "/uploadFile/"+uid+"/"+ app_name
			//String REST_SERVICE_URI = StartServiceListenerCore.http + "://" + StartServiceListenerCore.GATEWAY_URI;// +"/";
			//String surl = StartServiceListenerCore.http + "://" +StartServiceListenerCore.UPLOAD_FILE_URI +"/uploadFile/" + uid + "/" + app_name;
			//String surl = StartServiceListenerCore.UPLOAD_FILE_URI +"/" + uid + "/" + app_name;
			String surl = StartServiceListenerCore.UPLOAD_FILE_URI ;
			HttpPost httppost = new HttpPost(surl);
			httppost.addHeader("user_id", uid);
			httppost.addHeader("app_name", app_name);
			httppost.addHeader("integration.request.header.Accept", "'*/*'");
			httppost.addHeader("integration.request.header.Content-Type", "method.request.header.Content-Type");
			
			String x_api_key_upload_file = StartServiceListenerCore.getConfig().getProperty("x_api_key_upload_file");
			httppost.addHeader("x-api-key", "9TkCaSLyk45Fz8YXPW6Qm9UcaIsx70ir1aKYMRja");
			
			
//			httppost.addHeader("Accept", "'*/*'");
//			httppost.addHeader("Content-Type", "method.request.header.Content-Type");
			httppost.addHeader("x-amazon-apigateway-binary-media-types", "multipart/form-data");
//			"integration.request.header.Accept":"'*/*'",
//		    "integration.request.header.Content-Type":"method.request.header.Content-Type",
		    //Other headers
//		    "x-amazon-apigateway-binary-media-types": [
//		                                               "multipart/form-data"
//		                                           ]
			 
			
			
//			if ("amazonaws".equals(StartServiceListenerCore.gateway_type)) {
//				 
//
//			 
//				httppost.addHeader("x-api-key", StartServiceListenerCore.x_api_key);
//			 
//			}
			

			MultipartEntity entity = new MultipartEntity();

			// set the file input stream and file name as arguments
			
			entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
			
		 
			httppost.setEntity(entity);
//			if ("amazonaws".equals(StartServiceListenerCore.gateway_type)) {
//				 
//
//				 
//				httppost.addHeader("x-api-key", "KJZ5dwhy801ZthYfUejGr9ztFuzmZUXX6vmNmarp");
//			 
//			}
			// execute the request
			HttpResponse response = httpclient.execute(httppost);

			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");

			System.out.println("[" + statusCode + "] " + responseString);
			return true;

		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
			}
		}
		return false;
	}

}
