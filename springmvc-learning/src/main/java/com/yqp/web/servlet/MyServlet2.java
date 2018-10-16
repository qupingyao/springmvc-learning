package com.yqp.web.servlet;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet2 implements Servlet {

    private static Logger logger = Logger.getLogger(MyServlet2.class);

    private ServletConfig config;

    public MyServlet2() {
        logger.info("do-MyServlet2()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("do-init()");
        this.config = config;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("do-service()");
    }

}
