/**
 * 
 */
package com.mulesoft.training.pricing;

/**
 * @author MuleSoftTraining
 * The Request class holds the origin and destination for the pricing request that is submitted to the Airline System
 */
public class PriceRequest {
	protected String destination;
	protected String origin;

	/**
	 * @return destination the destination for this request
	 */
	public String getDestination() {
		return this.destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String argDestination) {
		this.destination = argDestination;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return this.origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String argOrigin) {
		this.origin = argOrigin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriceRequest [destination=" + this.destination + ", origin=" + this.origin
				+ "]";
	}
}
