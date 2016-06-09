package config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

 
public class WebAppInitializer implements WebApplicationInitializer  {

    @Override
    public void onStartup(ServletContext container)
    {
        //Tell jersey-spring3 the context is already initialized
        container.setInitParameter("contextConfigLocation", "NOTNULL");
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HibernateConfig.class, MvcConfig.class, ServiceConfig.class);
        container.addListener(new ContextLoaderListener(appContext));
        
        container.addFilter("Spring OpenEntityManagerInViewFilter", org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter.class)
        .addMappingForUrlPatterns(null, false, "/*");

    }
    
    
	
 }