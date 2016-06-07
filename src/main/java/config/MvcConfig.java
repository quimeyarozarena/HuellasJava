package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages={"resource"})
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	//Para poder delegar las peticiones que el framework no entienda al Servlet por default del servidor
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
