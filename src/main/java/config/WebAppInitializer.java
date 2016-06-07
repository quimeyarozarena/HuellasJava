package config;

import javax.servlet.ServletContext;

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
        appContext.register(MvcConfig.class, HibernateConfig.class, ServiceConfig.class);
        container.addListener(new ContextLoaderListener(appContext));
    }
	
 }