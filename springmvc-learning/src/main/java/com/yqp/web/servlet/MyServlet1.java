package com.yqp.web.servlet;

import com.yqp.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet1 implements Servlet {

    private static Logger logger = Logger.getLogger(MyServlet1.class);

    private ServletConfig config;

    public MyServlet1() {
        logger.info("do-MyServlet1()");
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
        UserService userService = this.getBeanFromAppCtx(config.getServletContext(), "userService", UserService.class);
        logger.info(userService.say("abc"));
        this.forward(config.getServletContext(), "/servlet/2", req, res);
    }

    private void forward(ServletContext sc, String url, ServletRequest req, ServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(req, res);
    }

    private <T> T getBeanFromAppCtx(ServletContext sc, String beanName, Class<T> classType) {
        ApplicationContext appCx = (ApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        T t = appCx.getBean(beanName, classType);
        return t;
    }

}
