package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override  //db ve hibernate ile ilgili configürasyonlar
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
             RootContextConfig.class
			};
	}

	@Override //Spring MVC config ayarları-bean tanımlamalarının yer aldığı class
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			WebMvcConfig.class
		};
	}

	@Override //hangi url hangi servlet ile ilişkilendirilecek
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}


}
