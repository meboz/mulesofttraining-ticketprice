package com.mulesoft.training;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import com.mulesoft.training.pricing.PriceOffer;
import com.mulesoft.training.pricing.PriceRequest;
import com.mulesoft.training.pricing.PriceResponse;

import edu.emory.mathcs.backport.java.util.Collections;

public class PrepareResponse implements Callable {

	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception { 
		MuleMessage message = eventContext.getMessage(); 
		@SuppressWarnings("unchecked")
		List<PriceOffer> payload = (List<PriceOffer>)message.getPayload(List.class);
		
		Collections.sort(payload, new Comparator<PriceOffer>() {

			@Override
			public int compare(PriceOffer o1, PriceOffer o2) {
				return Integer.compare(o1.getPrice() != 0 ? o1.getPrice() : Integer.MAX_VALUE, o2.getPrice() != 0 ? o2.getPrice() : Integer.MAX_VALUE);
			}
		});
		
		PriceResponse response = new PriceResponse((PriceRequest)message.getInvocationProperty("Request"));
		response.setOffers(new CopyOnWriteArrayList<PriceOffer>(payload));
		
		return response;
	}
}
