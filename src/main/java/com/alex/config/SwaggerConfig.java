//package com.alex.config;
//
//import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
//import com.mangofactory.swagger.plugin.EnableSwagger;
//import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
//import com.wordnik.swagger.model.ApiInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
package com.alex.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger
//@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alex.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("AlexCode API", "API for AlexCode",
                "AlexCode API terms of service", "alexverezubov@yahoo.com",
                "AlexCode API Licence Type", "AlexCode API License URL");
    }

}
//@Configuration
//@EnableSwagger
//public class SwaggerConfig {
//    private SpringSwaggerConfig springSwaggerConfig;
//    @Autowired
//    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
//        this.springSwaggerConfig = springSwaggerConfig;
//    }
//    @Bean
// Don't forget the @Bean annotation
//    public SwaggerSpringMvcPlugin customImplementation() {
//        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
//                apiInfo()).includePatterns("/.*");
//    }
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo("SaurzCode API", "API for Saurzcode",
//                "Saurzcode API terms of service", "mail2saurzcode@gmail.com",
//                "Saurzcode API Licence Type", "Saurzcode API License URL");
//        return apiInfo;
//    }
//}