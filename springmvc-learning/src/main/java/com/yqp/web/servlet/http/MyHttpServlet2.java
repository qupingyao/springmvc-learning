package com.yqp.web.servlet.http;

import com.yqp.web.bean.A;
import com.yqp.web.bean.B;
import com.yqp.web.bean.C;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet2 extends HttpServlet {

    private static Logger logger = Logger.getLogger(MyHttpServlet2.class);

    @Override
    public void init() throws ServletException {
        logger.info("do-init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("do-doGet()");
        logger.info((String) this.getContextAttr(super.getServletContext(), "val"));
        logger.info((String) this.getRequestAttr(req, "val"));
        logger.info(this.getRequestParam(req, "val"));
        this.getBeanFromAppCtx(super.getServletContext(), "a", A.class);
        this.getBeanFromAppCtx(super.getServletContext(), "b", B.class);
        this.getBeanFromAppCtx(super.getServletContext(), "c", C.class);
    }

    private Object getContextAttr(ServletContext sc, String name) {
        return sc.getAttribute(name);
    }

    private Object getRequestAttr(HttpServletRequest req, String name) {
        return req.getAttribute(name);
    }

    private String getRequestParam(HttpServletRequest req, String name) {
        return req.getParameter(name);
    }

    private <T> T getBeanFromAppCtx(ServletContext sc, String beanName, Class<T> classType) {
        ApplicationContext appCx = (ApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        T t = appCx.getBean(beanName, classType);
        return t;
    }

}
