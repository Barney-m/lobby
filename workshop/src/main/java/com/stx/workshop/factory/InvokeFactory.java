package com.stx.workshop.factory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
	public <T> T invokePost(ReqMap reqMap, String invokeUri, String contentType, Class<T> clazz) {

    	// Prepare HTTP Client
    	HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpReq = HttpRequest.newBuilder()
        									.uri(URI.create(invokeUri))
        									.header(RestConst.REQ_HDR_ACPT, RestConst.ACPT_TYPE_JSON)
        									.header(RestConst.REQ_HDR_CNTT_T, contentType)
        									.POST(getParamsUrlEncoded(reqMap.getReqMap()))
        									.build();

        try {
        	// Invoke API
        	HttpResponse<String> httpRsp = httpClient.send(httpReq, HttpResponse.BodyHandlers.ofString());
        	
        	// Get And Response Verify Result
        	ObjectMapper mapper = new ObjectMapper();
        	return (T) mapper.readValue(httpRsp.body(), clazz);
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
    	params.values().removeAll(Collections.singleton(null));
    	
    	String urlEncoded = params.entrySet()
				                .stream()
				                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue().toString(), StandardCharsets.UTF_8))
				                .collect(Collectors.joining("&"));
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }
}
