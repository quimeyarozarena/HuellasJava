package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

 
public class WebAppInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
	return new Class[] { MvcConfig.class };
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