package com.jingyusoft.sibyl.quotes.feed.yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.jingyusoft.sibyl.quotes.feed.QuoteFeeder;
import com.jingyusoft.sibyl.quotes.feed.yahoo.dto.YqlJsonQuote;
import com.jingyusoft.sibyl.quotes.feed.yahoo.dto.YqlJsonResponse;

@Service
public class YqlQuoteFeeder implements QuoteFeeder {

	private static List<String> getColumns(Class<?> clazz) {
		List<String> columns = Lists.newArrayList();
		for (Field field : clazz.getDeclaredFields()) {
			SerializedName serializedName = field.getAnnotation(SerializedName.class);
			if (serializedName != null) {
				columns.add(serializedName.value());
			}
		}
		return columns;
	}

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:com/jingyusoft/finance/config/application-context-feed.xml");
		applicationContext.getBean(YqlQuoteFeeder.class).test();
	}

	@Value("${feed.yahoo.yql.baseurl}")
	private String baseUrl;

	@Value("${feed.yahoo.yql.format}")
	private String format;

	@Value("${feed.yahoo.yql.env}")
	private String env;

	public void test() throws IOException {

		final String columns = StringUtils.join(getColumns(YqlJsonQuote.class), ",");
		String query = "select " + columns + " from yahoo.finance.quotes where symbol in ('MS', 'GS')";
		String fullUrlStr = baseUrl + "q=" + URLEncoder.encode(query, "UTF-8") + "&format=" + format + "&env=" + env;

		System.out.println(fullUrlStr);

		URL fullUrl = new URL(fullUrlStr);
		try (BufferedReader in = new BufferedReader(new InputStreamReader(fullUrl.openStream()))) {

			Gson gson = new Gson();
			YqlJsonResponse response = gson.fromJson(in, YqlJsonResponse.class);
			System.out.println(response.getQuery().getCount());
			System.out.println(response.getQuery().getResults().getQuotes().get(0).getSymbol());
		}
	}
}
