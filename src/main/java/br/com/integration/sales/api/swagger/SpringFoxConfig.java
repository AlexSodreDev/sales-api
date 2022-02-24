package br.com.integration.sales.api.swagger;

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

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

  @Bean
  public Docket salesApiSwagger() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.integration.sales.api.controllers"))
        .paths(PathSelectors.any())
        .build().apiInfo(this.metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title("Sales API")
        .description("API para criação e listagem de vendas e vendedor")
        .version("1.0")
        .contact(new Contact("Alexandre Sodre", "https://github.com/AlexSodreDev",
            "alexandre@testswagger"))
        .license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .build();
  }

}
