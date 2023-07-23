package com.ruisu.todo_list.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

@Bean
    public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ruisu.todo_list.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
}

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "To-Do Api",
                "La Api Rest de To-Do Api",
                "v1",
                "Terms of service",
                new Contact("Ruisu", "https://github.com/RuisuEurimonio?tab=repositories", "pipelinares2912@gmail.com")
                ,"license of Api", "Api licence URL" ,Collections.emptyList());
    }

}
