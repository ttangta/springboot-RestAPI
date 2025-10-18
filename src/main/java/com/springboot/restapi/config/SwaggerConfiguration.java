package com.springboot.restapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components()).info(apiInfo());
    }

    public Info apiInfo(){
        return new Info()
                .title("GET API 구현")
                .description("다양한 GET 요청 방식에 구현 (\"단순 요청 경로\" 또는 \"PathVariable(경로 변수)\" 또는 \"Query String\"을 통한 요청)")
                .version("1.0.0");
    }
}
