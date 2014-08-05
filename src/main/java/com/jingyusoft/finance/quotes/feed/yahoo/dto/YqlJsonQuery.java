package com.jingyusoft.finance.quotes.feed.yahoo.dto;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class YqlJsonQuery {

	@SerializedName("count")
	private int count;

	@SerializedName("created")
	private Date created;

	@SerializedName("results")
	private YqlJsonResults results;

	public int getCount() {
		return count;
	}

	public Date getCreated() {
		return created;
	}

	public YqlJsonResults getResults() {
		return results;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setResults(YqlJsonResults results) {
		this.results = results;
	}
}
