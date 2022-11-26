package com.stx.workshop.factory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stx.workshop.bean.ReqMap;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.exception.SvcException;

@Component
public class InvokeFactory {
	@SuppressWarnings("unchecked")
	public <T> T invokePost(ReqMap reqMap, String ivkUri, String cnttT, Class<T> cls) {
		Map<String, String> postMap = new HashMap<>();

    	// Prepare HTTP Client
    	HttpClient httpClt = HttpClient.newHttpClient();
        HttpRequest httpReq = HttpRequest.newBuilder()
        									.uri(URI.create(ivkUri))
        									.header(RestConst.REQ_HDR_ACPT, RestConst.ACPT_TYPE_JSON)
        									.header(RestConst.REQ_HDR_CNTT_T, cnttT)
        									.POST(getParamsUrlEncoded(reqMap.getReqMap()))
        									.build();

        try {
        	// Invoke API
        	HttpResponse<String> httpRsp = httpClt.send(httpReq, HttpResponse.BodyHandlers.ofString());
        	
        	// Get And Response Verify Result
        	ObjectMapper mapper = new ObjectMapper();
        	return (T) mapper.readValue(httpRsp.body(), cls);
        } catch (Exception e) {
        	throw new SvcException(e.getMessage());
        }
	}
	
	/**
     * Parse Map to POST Body application/x-www-form-urlencoded format
     * 
     * @param params
     * @return {@link HttpRequest.BodyPublisher}
     */
    private HttpRequest.BodyPublisher getParamsUrlEncoded(Map<String, Object> params) {
    	String urlEncoded = params.entrySet()
				                .stream()
				                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue().toString(), StandardCharsets.UTF_8))
				                .collect(Collectors.joining("&"));
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }
}
