package com.pet.survery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pet.survery"))
                .paths(PathSelectors.any())
                .build();
    }

        private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("小宠有佳问卷调查接口测试")
                .description("问卷调查")
                // 作者信息
                .contact(new Contact("zbw", "https://www.baidu.com/", "2431820970@qq.com"))
                .version("1.0.0")
                .build();
    }
}
