package com.jingyusoft.sibyl.quotes.feed.yahoo.dto;

import com.google.gson.annotations.SerializedName;

public class YqlJsonResponse {

	@SerializedName("query")
	private YqlJsonQuery query;

	public YqlJsonQuery getQuery() {
		return query;
	}

	public void setQuery(YqlJsonQuery query) {
		this.query = query;
	}
}
