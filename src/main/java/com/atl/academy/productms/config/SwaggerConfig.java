package com.atl.academy.productms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "PRODUCT MS REST API";
    private static final String DESCRIPTION = "Product MS Rest API";
    private static final String VERSION = "1.0";
    private static final String URL = "https://www.atltech.az";
    private static final String EMAIL = "Nijat.Dursunlu@atltech.az";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.html";
    private static final String BASE_PACKAGE = "com.atl.academy.productms";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .contact(new Contact("Product MS", URL, EMAIL))
                .license("Apache 2.0")
                .licenseUrl(LICENSE_URL)
                .version(VERSION)
                .build();
    }
}
