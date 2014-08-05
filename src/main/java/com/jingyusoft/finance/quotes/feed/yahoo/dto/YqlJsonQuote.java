package com.jingyusoft.finance.quotes.feed.yahoo.dto;

import com.google.gson.annotations.SerializedName;

public class YqlJsonQuote {

	@SerializedName("symbol")
	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
