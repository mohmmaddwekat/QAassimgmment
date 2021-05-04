package TestClasses;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.HandleRequestReponse;
import requestHandling.RestClientHandler;

public class TestPostRestAPI {
	
	@Test
	public void testCreatUsers() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.CREATEUser, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		String resquestCreatUsers = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUser);
		RestClientHandler.sendPost(connection, resquestCreatUsers, HTTPRequestsContentTypes.JSON);
		String PostCreatUsersresponse = RestClientHandler.readResponse(connection);
		System.out.println(PostCreatUsersresponse);
		assertTrue("Data is empty", !PostCreatUsersresponse.equals(""));
	}
	
	
	@Test
	public void testCreatUsers1() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.CREATEUser, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		String resquestCreatUsers1 = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUser);
		String resquestCreatUsers2 = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUser);
		assertTrue("Data is Already exiest ", !resquestCreatUsers1.equals(resquestCreatUsers2));	

		RestClientHandler.sendPost(connection, resquestCreatUsers1, HTTPRequestsContentTypes.JSON);

		RestClientHandler.sendPost(connection, resquestCreatUsers2, HTTPRequestsContentTypes.JSON);
		String PostCreatUsersresponse = RestClientHandler.readResponse(connection);
		System.out.println(PostCreatUsersresponse);
	}

	@Test
	public void testREGISTER() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.REGISTER, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		String resquestREGISTER = JSONUtils.readJSONObjectFromFile(FilesPaths.REGISTER);
		RestClientHandler.sendPost(connection, resquestREGISTER, HTTPRequestsContentTypes.JSON);
		String PostREGISTERresponse = RestClientHandler.readResponse(connection);
		System.out.println(PostREGISTERresponse);
	}
	
	@Test
	public void testREGISTER1() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.REGISTER, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		String resquestREGISTER1 = JSONUtils.readJSONObjectFromFile(FilesPaths.REGISTER);
		String resquestREGISTER2 = JSONUtils.readJSONObjectFromFile(FilesPaths.REGISTER);
		assertTrue("Data is Already exiest ", !resquestREGISTER1.equals(resquestREGISTER2));	

		RestClientHandler.sendPost(connection, resquestREGISTER1, HTTPRequestsContentTypes.JSON);
		RestClientHandler.sendPost(connection, resquestREGISTER2, HTTPRequestsContentTypes.JSON);
		
		String PostREGISTERresponse = RestClientHandler.readResponse(connection);
		
		System.out.println(PostREGISTERresponse);
	}
}
