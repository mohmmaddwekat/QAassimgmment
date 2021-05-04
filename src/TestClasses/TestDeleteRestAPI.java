package TestClasses;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestDeleteRestAPI {

	@Test
	public void testDELETEUsers() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.DELETEUsers, HTTPMethod.DELETE,
				HTTPRequestsContentTypes.JSON);
//		assertTrue("The connection is not available", connection.getResponseCode()==200);
		String  resquestDELETEUsers = JSONUtils.readJSONObjectFromFile(FilesPaths.DELETEUsers);
		RestClientHandler.sendDelete(connection, resquestDELETEUsers, HTTPRequestsContentTypes.JSON);
		String DELETEresponse = RestClientHandler.readResponse(connection);
		assertTrue("Data is empty", DELETEresponse.equals(""));	

	}
	@Test
	public void testDELETEUsers1() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.DELETEUsers, HTTPMethod.DELETE,
				HTTPRequestsContentTypes.JSON);

		String  resquestDELETEUsers = JSONUtils.readJSONObjectFromFile(FilesPaths.DELETEUsers);
		RestClientHandler.sendDelete(connection, resquestDELETEUsers, HTTPRequestsContentTypes.JSON);
		String DELETEresponse = RestClientHandler.readResponse(connection);
		System.out.println(DELETEresponse);

		String resquestCreatUsers = JSONUtils.readJSONObjectFromFile(FilesPaths.DELETEUsers);
		assertTrue("data is deleted",resquestCreatUsers.equals(DELETEresponse));

		RestClientHandler.sendPost(connection, resquestCreatUsers, HTTPRequestsContentTypes.JSON);
		
		String PostCreatUsersresponse = RestClientHandler.readResponse(connection);
		assertTrue("Data is empty", !PostCreatUsersresponse.equals(""));	

	}
}
