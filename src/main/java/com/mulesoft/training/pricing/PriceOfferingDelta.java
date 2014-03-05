/**
 * 
 */
package com.mulesoft.training.pricing;

/**
 * @author MuleSoft Training
 * 
 */
public class PriceOfferingDelta extends PriceOffering {


	public PriceOfferingDelta() {
		this.airline ="Delta";
	}

	protected int getPrice(String destination, String origin) throws AirportNotFoundException {

		int price;
		// Set Delta prices based on destination
		if (destination.equalsIgnoreCase("SFO")) {
			price = 400;
		} else if (destination.equalsIgnoreCase("LAX")) {
			price = 500;
		} else if (destination.equalsIgnoreCase("SEA")) {
			price = 600;
		} else {
			throw new AirportNotFoundException(destination + " Destination not found");
		}

		// Increment Delta prices based on origin
		if (price > 0) {
			if (origin.equalsIgnoreCase("YYZ")) {
				price = price + 157;
			} else if (origin.equalsIgnoreCase("ORD")) {
				price = price + 57;
			} else if (origin.equalsIgnoreCase("SQL")) {
				price = price + -107;
			} else {
				throw new AirportNotFoundException(origin + " Origin not found");
			}
		}

		return price;
	}
}
