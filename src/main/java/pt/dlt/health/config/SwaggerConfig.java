package pt.dlt.health.config;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    
    @Bean
    public Docket userApi() throws IOException {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData()).select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("pt.dlt.health.routing")).build()
                .useDefaultResponseMessages(false);
    }
    
    private ApiInfo metaData() throws IOException {
        return new ApiInfoBuilder()
                .title("Health Application REST API")
                .description("REST API with endpoints for manipulating Health enteties.")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
}
