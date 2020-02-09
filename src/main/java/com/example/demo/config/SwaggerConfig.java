package com.example.demo.config;

import com.example.demo.controller.SomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@Controller
public class SwaggerConfig {

    @ApiIgnore
    @GetMapping(value = "/")
    public String swagger() {
        return "redirect:swagger-ui.html";
    }

    @Bean
    public Docket regularApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(SomeController.class.getPackageName())).paths(PathSelectors.any())
                .build().enableUrlTemplating(true).useDefaultResponseMessages(false).groupName("Rest")
                .apiInfo(metaData());
    }

    @Bean
    public UiConfiguration swaggerUiConfig() {
        return UiConfigurationBuilder.builder().deepLinking(true).build();
    }

    private ApiInfo metaData() {
        return new ApiInfo("Springfox Deep Link Test",
                "Springfox Deep Link Test", "1.0",
                "Terms of service",
                new Contact("Ralph Avalon (Raphael Amoedo)", "https://ralphavalon.github.io/", "someuser@someemail.com"),
                "MIT", "https://opensource.org/licenses/MIT",
                Arrays.asList());
    }

}

