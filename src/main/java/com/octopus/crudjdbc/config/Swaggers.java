//package com.octopus.crudjdbc.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Created by luqinglin on 2017/12/1.
// */
//@Configuration
//@EnableSwagger2
//public class Swaggers {
//
//    /**
//     * swagger配置
//     * @return
//     */
//    @Bean
//    public Docket createRestApi() {
//
//        /**
//         * swagger需要扫描的包
//         */
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.octopus.crudjdbc.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 界面信息
//     * @return
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring-boot-jdbcTemplate代码生成接口")
//                .description("更多crud代码生成器请关注：https://github.com/yuchu2016")
//                .termsOfServiceUrl("https://github.com/yuchu2016/springboot-jdbcTemplate-generator")
//                .contact("yuchu")
//                .version("1.0")
//                .build();
//    }
//
//
//}