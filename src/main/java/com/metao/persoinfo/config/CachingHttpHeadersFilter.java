package com.metao.persoinfo.config;

import com.metao.persoinfo.properties.PersoInfoProperties;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CachingHttpHeadersFilter implements Filter {

  public static final int DEFAULT_DAYS_TO_LIVE = 1461; // 4 years
  public static final long DEFAULT_SECONDS_TO_LIVE = TimeUnit.DAYS.toMillis(DEFAULT_DAYS_TO_LIVE);

  private long cacheTimeToLive = DEFAULT_SECONDS_TO_LIVE;

  private PersoInfoProperties persoInfoProperties;

  public CachingHttpHeadersFilter(PersoInfoProperties persoInfoProperties) {
    this.persoInfoProperties = persoInfoProperties;
  }

  @Override
  public void init(FilterConfig filterConfig) {
    cacheTimeToLive = TimeUnit.DAYS.toMillis(persoInfoProperties.getHttp().getCache().getTimeToLiveInDays());
  }

  @Override
  public void destroy() {
    // Nothing to destroy
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    HttpServletResponse httpResponse = (HttpServletResponse) response;

    httpResponse.setHeader("Cache-Control", "max-age=" + cacheTimeToLive + ", public");
    httpResponse.setHeader("Pragma", "cache");

    // Setting Expires header, for proxy caching
    httpResponse.setDateHeader("Expires", cacheTimeToLive + System.currentTimeMillis());

    chain.doFilter(request, response);
  }
}
