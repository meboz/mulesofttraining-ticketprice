package com.mycompany;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.config.MuleProperties;
import org.mule.tck.junit4.FunctionalTestCase;

public class TicketPriceApplicationTest extends FunctionalTestCase {
	/**
	 * @throws Exception
	 */
	@Test
	public void testInputFormHttp() throws Exception {
		MuleClient client = muleContext.getClient();
		Map<String, Object> headers = new HashMap<String,Object>();
		
		headers.put("http.method", "GET");
		
		MuleMessage response = client.send("http://localhost:8088/tickets", "",headers,100000);
			
		String contentType = response.getInboundProperty("Content-Type");
		String status = response.getInboundProperty("http.status");
		String content = response.getPayloadAsString();
		assertEquals("text/html",contentType);
		assertEquals("200",status);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testInputFormHttpPost() throws Exception {
		MuleClient client = muleContext.getClient();
		Map<String, Object> headers = new HashMap<String,Object>();
		
		//Map<String, String> formData = new HashMap<String, String>();
		//formData.put("destination","SFO");
		//formData.put("origination","YYZ");
		
		headers.put("http.method", "POST");
		headers.put("Content-Type", "application/json");
		
		String formData = "{\"destination\":\"SFO\",\"origination\":\"YYZ\"}";
		
		MuleMessage response = client.send("http://localhost:8088/tickets", formData,headers,100000);
			
		String contentType = response.getInboundProperty("Content-Type");
		String status = response.getInboundProperty("http.status");
		String content = response.getPayloadAsString();
		assertEquals("text/plain",contentType);
		assertEquals("200",status);
		assertEquals("[{\"airline\":\"Delta\",\"price\":557},{\"airline\":\"United\",\"price\":572},{\"airline\":\"BritishAirways\",\"price\":555}]",content);
	}
	@Override
	protected Properties getStartUpProperties()
	{
		Properties properties = new Properties(super.getStartUpProperties());
		properties.put(MuleProperties.APP_HOME_DIRECTORY_PROPERTY, new File("mappings").getAbsolutePath());
		
		return properties;
	}
	
	@Override
	protected String getConfigResources() {
		// TODO Auto-generated method stub
		return "src/main/app/ticketprice.xml, src/main/app/inputform.xml";
	}

}
