package com.stx.workshop.interceptor;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.stx.workshop.annotation.StxAuth;
import com.stx.workshop.constant.RestConst;
import com.stx.workshop.exception.SvcException;

@Component
public class StxAuthInterceptor implements HandlerInterceptor {
	
	private static final String VFY_ACS_URI = "http://localhost:8190/centre/iam/auth/token/verifyAccess";
	
	/**
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)
	 */
	//This method is executed before accessing the interface. We only need to write the business logic to verify the login status here to verify the login status before the user calls the specified interface.
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            StxAuth stxAuth = ((HandlerMethod) handler).getMethodAnnotation(StxAuth.class);

            // Not Annotated
            if (null == stxAuth) {
                stxAuth = ((HandlerMethod) handler).getMethod().getDeclaringClass()
                        .getAnnotation(StxAuth.class);
            }

            // Annotated
            if (null != stxAuth) {
                final String authHdr = request.getHeader(RestConst.REQ_HDR_AUTH);

                // if Authentication Header not starts with Bearer
                if (null == authHdr || !authHdr.startsWith("Bearer")) {
                	response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Not Authenticated!");
                	return false;
                }

                // Retrieve JWT Token from Authentication Header
                String tkn = authHdr.substring(7, authHdr.length());
                
                // Call to Centre IAM to verify access
                Boolean isVld = vfyAcs(request, response, tkn);
                
                // Invalid Token
                if (!isVld) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Not Authenticated!");
                    return false;
                }
            }

        }
        return true;
    }

	/**
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)
	 */
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

	/**
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception)
	 */
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
    
    /**
     * Verify Access to check token is authenticated
     * 
     * @param request
     * @param response
     * @param tkn
     * @return {@link Boolean}
     */
    private Boolean vfyAcs(HttpServletRequest request, HttpServletResponse response, String tkn) {
    	// Prepare POST Form
    	Map<String, String> postMap = new HashMap<>();
    	postMap.put("accessToken", tkn);
    	
    	// Prepare HTTP Client
    	HttpClient httpClt = HttpClient.newHttpClient();
        HttpRequest vfyTknReq = HttpRequest.newBuilder()
        									.uri(URI.create(VFY_ACS_URI))
        									.header(RestConst.REQ_HDR_ACPT, RestConst.ACPT_TYPE_JSON)
        									.header(RestConst.REQ_HDR_CNTT_T, RestConst.ACPT_TYPE_X_WWW_FORM_URLENCODED)
        									.POST(getParamsUrlEncoded(postMap))
        									.build();

        try {
        	// Invoke API
        	HttpResponse<String> httpRsp = httpClt.send(vfyTknReq, HttpResponse.BodyHandlers.ofString());
        	
        	JSONObject jsonObject = new JSONObject(httpRsp.body());
        	
        	// Get And Response Verify Result
        	return (Boolean) jsonObject.get("is_valid");
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
    private HttpRequest.BodyPublisher getParamsUrlEncoded(Map<String, String> params) {
        String urlEncoded = params.entrySet()
		                            .stream()
		                            .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
		                            .collect(Collectors.joining("&"));
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }
}
