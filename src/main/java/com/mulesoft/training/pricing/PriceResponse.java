/**
 * 
 */
package com.mulesoft.training.pricing;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author MuleSoftTraining
 * The Request class holds the origin and destination for the pricing request that is submitted to the Airline System
 */
public class PriceResponse {
	protected PriceRequest request;
	protected Collection<PriceOffer> offers;

	/**
	 * Constructor creates a price response for a request, without offers
	 */
	public PriceResponse(PriceRequest argRequest){
		this.request = argRequest;
		this.offers = new CopyOnWriteArrayList<PriceOffer> ();
	}
	
	/**
	 * @return request the price request for this response
	 */
	public PriceRequest getRequest() {
		return this.request;
	}
	/**
	 * @param request the price request to set on this response
	 */
	public void setRequest(PriceRequest argRequest) {
		this.request = argRequest;
		return;
	}

	/**
	 * @return offers the offers for the price response, as a typed generic collection
	 */
	public Collection<PriceOffer> getOffers() {
		if (this.offers == null ) {
			this.offers = new CopyOnWriteArrayList<PriceOffer> ();
		}
		return this.offers;
	}
	/**
	 * @param request the price request to set on this response
	 */
	public void setOffers(CopyOnWriteArrayList<PriceOffer> argOffers) {
		this.offers = argOffers;
		return;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriceResponse [request=" + this.request.toString() + ", offers=" + this.offers.toString()
				+ "]";
	}
}
