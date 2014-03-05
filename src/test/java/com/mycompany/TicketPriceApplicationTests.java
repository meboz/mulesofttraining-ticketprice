package com.mycompany;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class TicketPriceApplicationTests extends FunctionalTestCase {

	@Test
	public void testHttp() throws Exception {
		MuleClient client = muleContext.getClient();
		Map<String, Object> headers = new HashMap<String,Object>();
		
		headers.put("http.method", "GET");
		
		MuleMessage response = client.send("http://localhost:8081/byron/SFO", "",headers,100000);
			
		String result = response.getPayloadAsString();
		assertEquals("300 Delta",result);
	}

	@Override
	protected String getConfigResources() {
		// TODO Auto-generated method stub
		return "src/main/app/ticketprice.xml";
	}

}
