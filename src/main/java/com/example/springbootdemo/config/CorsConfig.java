/**
 * 包名称：com.example.springbootdemo.config
 * 类名称：CorsConfig
 * 类描述：后端接收前端的请求
 * 创建人：@author 六叶草
 * 创建时间：2023年05月21日 16:43
 */
package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月21日 16:43
 * 项目名称:  SpringBootDemo
 * 文件名称:  CorsConfig
 * 文件描述:  @Description: 后端接收前端的请求
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }

}
