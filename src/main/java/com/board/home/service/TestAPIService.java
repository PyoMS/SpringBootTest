package com.board.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.board.util.ApiKey;


@Service
public class TestAPIService {
	private static final Logger logger = LoggerFactory.getLogger(TestAPIService.class);
	private final WebClient webClient;
	private final String QUESTIONMARK = "?";
	private final String AMPERSAND = "&";
	
	private ApiKey apikey;
	private final String API = ApiKey.getApiKey();
//	@Value("${apikey}")
//	private String API;
	
	public TestAPIService(WebClient.Builder webClientBuilder) {
//		this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
		this.webClient = webClientBuilder.baseUrl("https://opendart.fss.or.kr/api/list.json").build();
	}
	
	public String getFirstTodoTest() {
		String response =
				this.webClient.get().uri("/todos/1")
				.retrieve().bodyToMono(String.class)
				.block();
		return response;
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
}
