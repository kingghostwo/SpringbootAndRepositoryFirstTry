package com.ck.spring_boot_try.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "parameterFilter", urlPatterns = "/**")
public class ParameterFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.debug("----------------parameterFilter-----------");

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {

            @Override
            public String getParameter(String name) {
                String value = httpRequest.getParameter(name);
                if (StringUtils.isNotBlank(value)) {
                    return value.replaceAll("fuck", "***");
                }
                return super.getParameter(name);
            }

            @Override
            public String[] getParameterValues(String name) {
                String[] values = httpRequest.getParameterValues(name);
                if (values != null && values.length > 0) {
                    values[0] = values[0].replace("fuck", "*****");
                    return values;
                }
                return super.getParameterValues(name);
            }

        };

        chain.doFilter(wrapper, response);
    }

}
