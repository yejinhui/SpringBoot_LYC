/**
 * 包名称：com.example.springbootdemo.config
 * 类名称：MvcConfig
 * 类描述：静态资源加载器
 * 创建人：@author 六叶草
 * 创建时间：2023年07月05日 19:26
 */
package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月05日 19:26
 * 项目名称:  SpringBootDemo
 * 文件名称:  MvcConfig
 * 文件描述:  @Description: 静态资源加载器
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 静态资源加载设置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}
