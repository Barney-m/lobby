package com.stx.workshop.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * URL Utilities
 * 
 * @author Ken Shen
 * @version 1.0
 */
public class UrlUtil {
	private static final Pattern ABSOLUTE_URL = Pattern.compile("\\A[a-z0-9.+-]+://.*", Pattern.CASE_INSENSITIVE);
	
	private static final String SCHEME_HTTPS = "https";
	
	private static final String DEF_PORT_HTTPS = "443";
	
	private static final String SCHEME_HTTP = "http";
	
	private static final String DEF_PORT_HTTP = "80";
	
	private UrlUtil() {}
	
	public static String getAbsUrl(HttpServletRequest req, String rltvUrl) {
		String port = PropertyUtil.getUrlPort();
		
		if (StringUtils.isBlank(port)) {
			port = String.valueOf(req.getServerPort());
		}
		String ctx = req.getContextPath();
		String dmnNm = PropertyUtil.getUrlDmnNm();
		if (StringUtils.isBlank(dmnNm)) {
			dmnNm = req.getServerName();
		}
		String scheme = PropertyUtil.getUrlScheme();
		if (StringUtils.isBlank(scheme)) {
			scheme = getCleanScheme(req.getScheme());
		}
		
		return getAbsUrl(scheme, dmnNm, port, ctx, rltvUrl, true);
	}
	
	public static String getAbsUrl(HttpServletRequest req, String rltvUrl, boolean isAppendCtx) {
		String port = PropertyUtil.getUrlPort();
		
		if (StringUtils.isBlank(port)) {
			port = String.valueOf(req.getServerPort());
		}
		String ctx = req.getContextPath();
		String dmnNm = PropertyUtil.getUrlDmnNm();
		if (StringUtils.isBlank(dmnNm)) {
			dmnNm = req.getServerName();
		}
		String scheme = PropertyUtil.getUrlScheme();
		if (StringUtils.isBlank(scheme)) {
			scheme = getCleanScheme(req.getScheme());
		}
		
		return getAbsUrl(scheme, dmnNm, port, ctx, rltvUrl, isAppendCtx);
	}
	
	public static boolean isAbsUrl(String url) {
		if (null == url) {
			return false;
		}
		
		return ABSOLUTE_URL.matcher(url).matches();
	}
	
	public static String getAbsUrl(String httpScheme, String domainName, String portNumber,
			String contextPath, @NonNull String relativeUrl, boolean isAppendCtx) {
		String dmnNm = domainName;
		String port = portNumber;
		String ctx = contextPath;
		String scheme = httpScheme;
		String url = relativeUrl;
		String qry = null;
		
		if (isAbsUrl(url) && StringUtils.isNotEmpty(url)) {
			if (!url.startsWith(ctx) && isAppendCtx) {
				url = ctx + url;
			}
		} else {
			// Rewrite URL
			UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).build();
			if (StringUtils.isBlank(scheme) ) {
				// Revert
				scheme = uriComponents.getScheme();
			}
			
			if (StringUtils.isBlank(dmnNm)) {
				dmnNm = uriComponents.getPath();
				port = String.valueOf(uriComponents.getPort());
			}
			
			url = uriComponents.getPath();
			qry = uriComponents.getQuery();
		}
		
		return calcRltvUrl(dmnNm, port, scheme, url, qry);
	}
	
	private static String calcRltvUrl(String dmnNm, String port, String scheme, String url, String qry) {
		if (null == dmnNm || null == scheme) {
			return url;
		}
		
		UriComponentsBuilder blder = UriComponentsBuilder.fromPath(StringUtils.trimToEmpty(url))
											.scheme(scheme).host(dmnNm).query(qry);
		
		if (StringUtils.isNotBlank(port)) {
			if ((SCHEME_HTTPS.equals(scheme) && DEF_PORT_HTTPS.equals(port))
				|| (SCHEME_HTTP.equals(scheme)&& DEF_PORT_HTTP.equals(port))) {
				// Do Nothing...
			} else {
				// Only Append if not default
				blder.port(port);
			}
		}
		
		return blder.toUriString();
	}
	
	private static String getCleanScheme(String scheme) {
		if (SCHEME_HTTPS.equalsIgnoreCase(scheme)) {
			return SCHEME_HTTPS;
		} else if (SCHEME_HTTP.equalsIgnoreCase(scheme)) {
			return SCHEME_HTTP;
		}
		
		return null;
	}
}
