package TestClasses;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestPutRestAPI {
	
	@Test
	public void testUPDATE() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.UPDATE, HTTPMethod.PUT,
				HTTPRequestsContentTypes.JSON);
		String resquestUPDATE = JSONUtils.readJSONObjectFromFile(FilesPaths.UPDATE);
		RestClientHandler.sendPut(connection, resquestUPDATE, HTTPRequestsContentTypes.JSON);
		String PutUPDATEresponse = RestClientHandler.readResponse(connection);
		System.out.println(PutUPDATEresponse);
	}

	@Test
	public void testUPDATEEmty() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.UPDATE, HTTPMethod.PUT,
				HTTPRequestsContentTypes.JSON);
		String resquestUPDATE = JSONUtils.readJSONObjectFromFile(FilesPaths.UPDATEEmty);
		System.out.println(resquestUPDATE);
		assertTrue("Data is empty",resquestUPDATE.equals(""));

		RestClientHandler.sendPut(connection, resquestUPDATE, HTTPRequestsContentTypes.JSON);
		String PutUPDATEresponse = RestClientHandler.readResponse(connection);
		System.out.println(PutUPDATEresponse);
	}
	

}
