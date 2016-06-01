package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration  //indica que esta clase declara uno o más métodos anotados con @Bean, los cuales deben ser procesados por el contenedor de Spring para generar definiciones de los beans y peticiones de esos beans en tiempo de ejecución
@ComponentScan(basePackages={"resource","service"})
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	//Para poder delegar las peticiones que el framework no entienda al Servlet por default del servidor
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
