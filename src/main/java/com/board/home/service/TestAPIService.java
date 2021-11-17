package com.board.home.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.board.util.ReadFile;


@Service
public class TestAPIService {
	private static final Logger logger = LoggerFactory.getLogger(TestAPIService.class);
	private final WebClient webClient;
	private final String QUESTIONMARK = "?";
	private final String AMPERSAND = "&";
	
	Path path = Paths.get("src/main/resources/apikey.properties");
	private ReadFile apikey = new ReadFile(path);
	private final String API = apikey.getStringData();
	
	public TestAPIService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://opendart.fss.or.kr/api/list.json").build();
	}
	
	
	//TODO 해당 입력 정보를 array 형태로 받아서 for문으로 AMPERSAND 처리할 것. - json to array 처리.
	public String getDartTest() {
		System.out.println("@getDartTest API - " + API);
		String[] str = {
				"bgn_de=20200117",
				"end_de=20200117",
				"corp_cls=Y",
				"page_no=1",
				"page_count=10"};
		
		StringBuffer uri=new StringBuffer();
		uri.append(QUESTIONMARK).append("crtfc_key=").append(API);
		for (int i = 0; i < str.length; i++) {
			uri.append(AMPERSAND);
			uri.append(str[i]);
		}
		logger.debug("uri data - "+uri.toString());
		String response =
				this.webClient.get().uri(uri.toString())
				.retrieve().bodyToMono(String.class)
				.block();
		return response;
	}
	
	/**
	 * json data 받아서 jsonarray로 처리.
	 * TODO array의 항목명은 어떻게 처리? ex) bgn_de=20200117 의 경우 'bgn_de'에 해당하는 값*/
	public String getDartTest(JSONObject jsonobj) {
		System.out.println("@getDartTest API - " + API);
		JSONArray array = (JSONArray)jsonobj.get("list");
		String[] str = (String[])array.toArray();
		
		StringBuffer uri=new StringBuffer();
		uri.append(QUESTIONMARK).append("crtfc_key=").append(API);
		for (int i = 0; i < str.length; i++) {
			uri.append(AMPERSAND);
			uri.append(str[i]);
		}
		logger.debug("uri data - "+uri.toString());
		String response =
				this.webClient.get().uri(uri.toString())
				.retrieve().bodyToMono(String.class)
				.block();
		return response;
	}
}
