package project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer { private String uploadPath;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:templates/parts/image/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:templates/parts/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:templates/parts/js/");
        registry.addResourceHandler("/parts/image/**").addResourceLocations("classpath:templates/parts/image/");
    }
}
