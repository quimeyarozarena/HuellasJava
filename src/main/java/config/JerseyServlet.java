package config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

@WebServlet(urlPatterns = {"/rest/*"}, initParams = {
	    @WebInitParam(name = "com.sun.jersey.config.property.packages",
	            value = "resource")})
	public class JerseyServlet extends SpringServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	}