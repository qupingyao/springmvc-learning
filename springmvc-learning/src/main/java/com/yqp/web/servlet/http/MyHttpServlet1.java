package com.yqp.web.servlet.http;

import com.yqp.web.bean.A;
import com.yqp.web.bean.B;
import com.yqp.web.bean.C;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet1 extends HttpServlet {

    private static Logger logger = Logger.getLogger(MyHttpServlet1.class);

    @Override
    public void init() throws ServletException {
        logger.info("do-init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("do-doGet()");
        this.setRequestAttr(req,"val","cba");
        this.getBeanFromAppCtx(super.getServletContext(),"a",A.class);
        this.getBeanFromAppCtx(super.getServletContext(),"b",B.class);
        this.getBeanFromAppCtx(super.getServletContext(),"c",C.class);
        this.forward(super.getServletContext(),"/httpservlet/2",req,resp);
    }

    private void getRequestSys(HttpServletRequest req) {
        logger.info("requesturi:" + req.getRequestURI());
        logger.info("requesturl:" + req.getRequestURL());
    }

    private void setRequestAttr(HttpServletRequest req, String name,Object object) {
        req.setAttribute(name,object);
    }

    private void forward(ServletContext sc, String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(req, resp);
    }

    private <T> T getBeanFromAppCtx(ServletContext sc, String beanName, Class<T> classType) {
        ApplicationContext appCx = (ApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        T t = appCx.getBean(beanName, classType);
        return t;
    }

}
