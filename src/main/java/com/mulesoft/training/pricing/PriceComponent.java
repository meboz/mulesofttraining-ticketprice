package com.mulesoft.training.pricing;


/**
 * @author MuleSoftTraining
 * This PriceComponent is used for the first 5 Labs as a quick way of returning Prices based on strings.
 *
 */
public class PriceComponent {

	public String getPrice(String destination) {
		
		int slashIndex;
		
		// Removes Leading Slash
		slashIndex = destination.lastIndexOf("/");
		if (slashIndex!=-1){
			destination = destination.substring(slashIndex+1);
		}
		
		
		if (destination != null && "SFO".equalsIgnoreCase(destination.trim())) {
			return "300";
		} else if (destination != null && "SEA".equalsIgnoreCase(destination.trim())) {
			return "400";
		} else if (destination != null && "LAX".equalsIgnoreCase(destination.trim())) {
			return "500";
		} else {
			return "This destination is not available";
		}
		
	}
}
