package config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages={"resource"})
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	
/*	@Autowired
	LocalContainerEntityManagerFactoryBean entityManagerFactory;	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
		 interceptor.setEntityManagerFactory(entityManagerFactory.getObject());
		 registry.addWebRequestInterceptor(interceptor);
	}


*/
}
