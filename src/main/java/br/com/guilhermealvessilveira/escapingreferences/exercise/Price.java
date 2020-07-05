package br.com.guilhermealvessilveira.escapingreferences.exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Price {

	private final Map<String,Double> rates;
	private final Double value;
	
	public Price(final Double value) {
		this.value = value;
		rates = new HashMap<>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}
		
	public Double convert(final String toCurrency) {
		
		if (toCurrency.equals("USD")) {
			return value;
		}

		else {
			final Double conversion = rates.get("USD") / rates.get(toCurrency);
			return conversion * value;
		}
	}

	Double getValue() {
		return value;
	}
	
	public String toString() {
		return value.toString();
	}

	//Return unmodifiable map or use method getRate
	public Map<String,Double> getRates() {
		return Collections.unmodifiableMap(rates);
	}

	public Double getRate(final String currency) {
		return rates.get(currency);
	}
}
