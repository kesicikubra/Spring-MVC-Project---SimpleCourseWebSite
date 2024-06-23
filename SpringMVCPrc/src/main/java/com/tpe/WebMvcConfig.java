package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc  //mvc yapısında çalışılacak
@ComponentScan("com.tpe") //componentların taranıp bean oluşturulmasını sağlar
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean //Kullanıcıya görebilir heale getirebilmek için viewResolver kullanıyoruz
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class); //daha az java kodu yazarak jsp dosyaları yazmaya yarar
		resolver.setPrefix("/WEB-INF/views/"); //bu dosyaların nerde olacağı
		resolver.setSuffix(".jsp"); //java server page uzantılı dosyalar kullan
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) { //css,style,image gibi dosyalar için yol
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
	}

}
