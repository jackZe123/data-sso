/**   
* @Title: SwaggerConfig.java 
* @Package com.haocang.project.swagger 
* @Description: TODO(用一句话描述该文件做什么) 
* @author （zxx）  
* @date 2017年12月13日 下午2:11:52 
* @version V1.0   
*/
package com.yipai.utils;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: SwaggerConfig 
* @Description: TODO(公司: 上海昊沧系统控制技术有限责任公司) 
* 
* @author (何戎欣)  
* @date 2017年12月13日 下午2:11:52 
* @ClassName: SwaggerConfig
* @param     参数
* @return return_type    返回类型
* @throws
* @version V1.0
* @Title: enclosing_method  
*/
@Configuration //必须存在
@EnableSwagger2 //必须存在
//@EnableWebMvc //必须存在
//@ComponentScan(basePackages = {"com.haocang.dispatch.controller"}) //必须存在 扫描的API Controller package 
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
//        //
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .paths(PathSelectors.any())
//                .build();
        //添加head参数配置start

//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
//        pars.add(tokenPar.build());
//        //添加head参数配置end
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .paths(PathSelectors.any())
//                .build()
//                .globalOperationParameters(pars);//注意这里
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true)
                .select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList= new ArrayList();


        apiKeyList.add(new ApiKey("x-auth-token", "x-auth-token", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("昊沧", "http://www.haocang.com", "herongxin@haocang.com");
        return new ApiInfoBuilder()
				.description("临港项目 Api 文档")
				.title(" Api")
				.contact(contact)
				.version("1.0.0.0000")
				.build();
    }

}
