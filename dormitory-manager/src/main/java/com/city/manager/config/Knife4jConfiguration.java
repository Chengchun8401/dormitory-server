package com.city.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @version v1.0
 * @ClassName: Knife4jConfiguration
 * @Description: Swagger配置
 * @Author: CitySpring
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("智慧楼栋管理端接口文档")
                        .description("智慧楼栋管理端接口文档")
                        .termsOfServiceUrl("http://localhost:5453")
                        .contact("3494525791@qq.com")
                        .version("1.0.2")
                        .build())
                //分组名称
                .groupName("Beta:1.0.2")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.city.manager.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
