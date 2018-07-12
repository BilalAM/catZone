package com.bilal.catZone;

import com.sun.security.auth.UserPrincipal;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCustomConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/UPLOADED_CAT_IMAGES/**", "/UPLOADED_OWNER_IMAGES/**")
                .addResourceLocations("file:UPLOADED_CAT_IMAGES/")
                .addResourceLocations("file:UPLOADED_OWNER_IMAGES/");
    }
}
