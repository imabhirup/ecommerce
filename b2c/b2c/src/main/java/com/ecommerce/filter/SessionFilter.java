package com.ecommerce.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse ) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.addCookie(new Cookie("JSESSIONID", request.getSession().getId()));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
