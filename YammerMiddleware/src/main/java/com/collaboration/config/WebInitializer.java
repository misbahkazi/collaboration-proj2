package com.collaboration.config;



import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


	public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
	{
		@Override
		protected void customizeRegistration(ServletRegistration.Dynamic registration) {
			System.out.println("customizeRegistration");
			registration.setInitParameter("dispatchOptionRequest", "true");
			registration.setAsyncSupported(true);
		}

		@Override
		protected Class<?>[] getRootConfigClasses() 
		{
			System.out.println("====RootConfigClasses====");
			return new Class[] { WebResolver.class, DBConfig.class };
		}

		@Override
		protected Class<?>[] getServletConfigClasses() 
		{
			System.out.println("===getServletConfigClasses===");
			return null;
		}

		@Override
		protected String[] getServletMappings() 
		{
			System.out.println("====getServletMapping====");
			return new String[] { "/" };
		}

		@Override
		protected Filter[] getServletFilters()
		{
			CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
			encodingFilter.setEncoding(StandardCharsets.UTF_8.name());
			return new Filter[] {encodingFilter};
		}
	}

