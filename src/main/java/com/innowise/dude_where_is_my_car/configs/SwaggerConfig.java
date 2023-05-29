package com.innowise.dude_where_is_my_car.configs;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//https://stackoverflow.com/questions/59898874/enable-authorize-button-in-springdoc-openapi-ui-for-bearer-token-authentication?rq=2
@Configuration
public class SwaggerConfig {
    @Value("${app.version}")
    private String appVersion;
    @Value("${app.name}")
    private String appName;

    @Bean
    public OpenAPI customOpenAPI() {
        String securitySchemeName = "bearerAuth";
        final String apiTitle = this.appName + " API";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .info(new Info().title(apiTitle).version(this.appVersion));
    }

    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/**")
                .build();
    }
}
