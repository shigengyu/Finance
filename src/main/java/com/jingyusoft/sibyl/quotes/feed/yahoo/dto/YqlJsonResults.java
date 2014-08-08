package com.jingyusoft.sibyl.quotes.feed.yahoo.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class YqlJsonResults {

	@SerializedName("quote")
	private List<YqlJsonQuote> quotes;

	public List<YqlJsonQuote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<YqlJsonQuote> quotes) {
		this.quotes = quotes;
	}
}
