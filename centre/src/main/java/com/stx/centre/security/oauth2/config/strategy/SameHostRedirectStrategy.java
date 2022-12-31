package com.stx.centre.security.oauth2.config.strategy;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.RedirectStrategy;

import com.stx.workshop.util.LogUtil;
import com.stx.workshop.util.UrlUtil;

public class SameHostRedirectStrategy implements RedirectStrategy {
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public void sendRedirect(HttpServletRequest req, HttpServletResponse res, String url) throws IOException {
		String redirectUrl = UrlUtil.getAbsUrl(req, url);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Redirecting to '{}'", LogUtil.encode(redirectUrl));
		}
		res.sendRedirect(redirectUrl);
	}
}
