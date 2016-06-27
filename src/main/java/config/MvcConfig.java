package config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages={"resource"})
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

}
