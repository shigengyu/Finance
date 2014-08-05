package com.jingyusoft.finance.quotes.model;

public class YqlQuote extends Quote {

	private Double bid;

	private Double ask;

	private String currency;

	private Double volume;

	public Double getAsk() {
		return ask;
	}

	public Double getBid() {
		return bid;
	}

	public String getCurrency() {
		return currency;
	}

	public Double getVolume() {
		return volume;
	}

	public void setAsk(Double ask) {
		this.ask = ask;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}
}
