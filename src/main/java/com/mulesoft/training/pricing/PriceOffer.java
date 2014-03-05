/**
 * 
 */
package com.mulesoft.training.pricing;

/**
 * @author MuleSoft Training
 * Each Airline returns a Pricing Offer corresponding to the request made
 */

public class PriceOffer {
	protected String airline;
	protected int price;
	
	/**
	 * Default Constructor, with empty string for airline, and 0 for price 
	 */
	public PriceOffer(){
		this.airline ="";
		this.price=0;
		
	}
	
	/**
	 * Constructor with airline
	 * @param airline
	 */
	public PriceOffer(String airline) {
		this.airline = airline;
		this.price = 0;
	}
	
	/**
	 * Constructor with airline and price
	 * @param airline
	 * @param price
	 */
	public PriceOffer(String airline, int price) {
		this.airline = airline;
		this.price = price;
	}
	
	
	/**
	 * @return the airline
	 */	
	public String getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return this.price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriceOffer [airline=" + airline + ", price=" + price + "]";
	}
	
}
