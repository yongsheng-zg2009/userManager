package com.cyx.helper;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Kylin
 *
 */
@Component
public class ApplicationHelper implements ApplicationContextAware{
    private static ApplicationContext applicationContext;  
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	ApplicationHelper.applicationContext = applicationContext;
    }
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
}