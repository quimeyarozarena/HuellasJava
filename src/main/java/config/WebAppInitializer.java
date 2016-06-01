package config;


import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

 
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getServletConfigClasses() {
	return new Class[] {MvcConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
	return new String[] { "/" };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
	return new Class[] {HibernateConnection.class};
	}
	
 }