package com.board.home.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.board.util.ApiKey;
import com.board.util.CreateZip;
import com.board.util.ReadFile;
import com.board.util.UnZip;

import reactor.core.publisher.Flux;


@Service
public class TestAPIService {
	private static final Logger logger = LoggerFactory.getLogger(TestAPIService.class);
	private WebClient webClient;
	private final String QUESTIONMARK = "?";
	private final String AMPERSAND = "&";
	private final String RESOURCEPATH = "src/main/resources/"; 
	
	Path path = Paths.get("src/main/resources/apikey.properties");
	private ReadFile apikey = new ReadFile(path);
	private final String API = apikey.getStringData();
	
	public TestAPIService() {}
	
//	public TestAPIService(WebClient.Builder webClientBuilder) {
//		this.webClient = webClientBuilder.baseUrl("https://opendart.fss.or.kr/api/corpCode.xml").build(); //고유번호
//		this.webClient = webClientBuilder.baseUrl("https://opendart.fss.or.kr/api/list.json").build(); // list
//	}
	
	/**
	 * 고유번호 조회*/
	public String getUniqueNumber() {
		
		StringBuffer uri=new StringBuffer();
		uri.append("https://opendart.fss.or.kr/api/corpCode.xml");
		uri.append(QUESTIONMARK).append("crtfc_key=").append(API);
		
		String zipfile = RESOURCEPATH+"corpCode.zip";
		Path path = Paths.get(zipfile);
	    WebClient client = WebClient.builder().baseUrl(uri.toString()).build();
	    
	    Flux<DataBuffer> dataBufferFlux = client.get().retrieve().bodyToFlux(DataBuffer.class);
	    DataBufferUtils.write(dataBufferFlux, path, StandardOpenOption.CREATE).block(); //Creates new file or overwrites exisiting file

	    //TODO unzip -> return String
	    
	    String response="";
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
		uri.append("https://opendart.fss.or.kr/api/list.json");
		uri.append(QUESTIONMARK).append("crtfc_key=").append(API);
		for (int i = 0; i < str.length; i++) {
			uri.append(AMPERSAND);
			uri.append(str[i]);
		}
		logger.debug("uri data - "+uri.toString());
		
		WebClient client = WebClient.builder().baseUrl(uri.toString()).build();
		String response =
				client.get().uri(uri.toString())
				.retrieve().bodyToMono(String.class)
				.block();
		
		return response;
	}
	
	/**
	 * json data 받아서 jsonarray로 처리.
	 * TODO array의 항목명은 어떻게 처리? ex) bgn_de=20200117 의 경우 'bgn_de'에 해당하는 값
	 * @throws Exception */
	public String getDartTest(JSONObject jsonobj) throws Exception {
		System.out.println("@getDartTest API - " + API);
		JSONParser jsonParser = new JSONParser();
		
		JSONObject jobj = (JSONObject)jsonParser.parse(jsonobj.toJSONString()); //json 전체 파싱
		
//		String[] str = (String[])array.toArray(); //TODO test
		String[] str = {};
		
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
