package com.hsjry.zhuque.config;
 
 
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
 
/**
 * Swagger2 配置类
 */
//@EnableSwagger2
//@Configuration
public class Swagger2Config {
    @Bean
    public Docket swaggerPluginConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())                     //Api文档描述
                .select()                               //选择哪些路径和Api会生成文档
                .apis(RequestHandlerSelectors.basePackage("com.swagger.demo.controller"))    //对指定路径下Api进行监控
                .paths(PathSelectors.any())             //对所有路径进行监控
                .build();
    }
 
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Test Demo接口文档")
                .description("API 接口文档")
                .termsOfServiceUrl("http://localhost")
                .version("1.0.0")
                .contact(new Contact("takano","","xxxxxx@qq.com"))
                .build();
    }
}