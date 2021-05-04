package TestClasses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.HandleRequestReponse;
import requestHandling.RestClientHandler;

public class TestGetRestAPI {

	@Test
	public void TestLISTUSERS() throws Exception  {

		String GetLISTUSERSresponse = HandleRequestReponse.sendGetRequest(URLs.LISTUSERS);
		
		System.out.println(GetLISTUSERSresponse);
		
		assertTrue("Data is empty", !GetLISTUSERSresponse.equals(""));	

	}
	


	
	@Test
	public void TestSINGLEUSER() throws Exception  {
		
		String GetSINGLEUSERresponse = HandleRequestReponse.sendGetRequest(URLs.SINGLEUSER);
		
		System.out.println(GetSINGLEUSERresponse);
		
		assertTrue("Data is empty", !GetSINGLEUSERresponse.equals(""));
		

	}
	



	
}
