package com.mycompany;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class TicketPriceApplicationTest extends FunctionalTestCase {

	@Test
	public void testTicketPriceHttp() throws Exception {
		MuleClient client = muleContext.getClient();
		Map<String, Object> headers = new HashMap<String,Object>();
		
		headers.put("http.method", "GET");
		
		MuleMessage response = client.send("http://localhost:8081/SFO", "",headers,100000);
			
		String result = response.getPayloadAsString();
		assertEquals("[300 Delta, 300 American, 300 United]",result);
	}

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

	@Override
	protected String getConfigResources() {
		// TODO Auto-generated method stub
		return "src/main/app/ticketprice.xml, src/main/app/inputform.xml";
	}

}
