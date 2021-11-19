package com.fabricasoftware.SrNavalha.conf;
import java.util.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConfigurationProperties("ads04.swagger")
public class Swagger {

    private String swaggerPath;

    private String nome;

    @Bean
    public Docket allApi() {
        List<Parameter> aParameters = new ArrayList<Parameter>();
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        protocols.add("https");
        return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
                .groupName("All")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
                .protocols(protocols)
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true).globalOperationParameters(aParameters);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(nome)
                .description("Sistema criado apra o gerenciamento dos Serviços oferecidos por barbeiros autônomos.")
                .termsOfServiceUrl("http://localhost:8080/swagger")
                .license("MIT")
                .licenseUrl("https://github.com/jhonathandosreis/Sr-Navalha/blob/main/LICENSE")
                .version("2.0")
                .build();
    }
    public String getSwaggerPath() {
        return swaggerPath;
    }
    public void setSwaggerPath(String swaggerPath) {
        this.swaggerPath = swaggerPath;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}