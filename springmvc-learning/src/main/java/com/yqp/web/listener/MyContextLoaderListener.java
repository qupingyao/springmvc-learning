package com.yqp.web.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextLoaderListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(MyContextLoaderListener.class);

    public MyContextLoaderListener() {
        logger.info("do-MyContextLoaderListener()");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("do-contextInitialized()");
        this.setContextAttr(sce.getServletContext(), "val", "abc");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private void setContextAttr(ServletContext sc, String name, Object object) {
        sc.setAttribute(name, object);
    }
}
