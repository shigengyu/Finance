package com.jingyusoft.finance.quotes.feed.yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jingyusoft.finance.quotes.feed.QuoteFeeder;
import com.jingyusoft.finance.quotes.feed.yahoo.dto.YqlJsonResponse;

@Service
public class YahooYqlQuoteFeeder implements QuoteFeeder {

	public static void main(String[] args) throws IOException {
		new YahooYqlQuoteFeeder().test();
	}

	@Value("#{feed.yahoo.yql.baseurl}")
	private final String baseUrl = "http://query.yahooapis.com/v1/public/yql?";

	public void test() throws IOException {

		String query = "select * from yahoo.finance.quotes where symbol in ('MS', 'GS')";
		String fullUrlStr = baseUrl
				+ "q="
				+ URLEncoder.encode(query, "UTF-8")
				+ "&format=json&env=store%3A%2F/datatables.org%2Falltableswithkeys";

		System.out.println(fullUrlStr);

		URL fullUrl = new URL(fullUrlStr);
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				fullUrl.openStream()))) {

			Gson gson = new Gson();
			YqlJsonResponse response = gson.fromJson(in, YqlJsonResponse.class);
			System.out.println(response.getQuery().getCount());
			System.out.println(response.getQuery().getResults().getQuotes()
					.get(0).getSymbol());
		}
	}
}
