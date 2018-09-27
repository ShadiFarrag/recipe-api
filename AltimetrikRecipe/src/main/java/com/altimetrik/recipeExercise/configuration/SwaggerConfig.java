package com.altimetrik.recipeExercise.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /*public static final Contact DEFAULT_CONTACT = new Contact(
      "Shadi Farrag", "https://github.com/ShadiFarrag/recipe-api", "shadi.farrag@gmail.com");
  
  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
      "Recipe API", "Search Meals Recipes", "1.0",
      "urn:tos", DEFAULT_CONTACT, 
      "None", "");

  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
      new HashSet<String>(Arrays.asList("application/json",
          "application/xml"));*/

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
    		.select()
            .apis(RequestHandlerSelectors.basePackage("com.altimetrik.recipeExercise.controller"))
            .paths(regex("/altimetrik.*"))
            .build()
            .apiInfo(metaData());
    
        /*.apiInfo(DEFAULT_API_INFO)
        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);*/
  }
  
  
  private ApiInfo metaData() {
      return new ApiInfoBuilder()
              .title("Recipe API Exercise")
              .description("\"Search Meals Recipes\"")
              .version("1.0.0")
              .license("None")
              .licenseUrl("")
              .contact(new Contact("Shadi Farrag", "https://github.com/ShadiFarrag/recipe-api", "shadi.farrag@gmail.com"))
              .build();
  }
  
}
