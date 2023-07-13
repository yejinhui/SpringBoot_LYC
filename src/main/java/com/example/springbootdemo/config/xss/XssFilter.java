/**
 * 包名称：com.example.springbootdemo.config.xss
 * 类名称：XssFilter
 * 类描述：前端路径过滤器
 * 创建人：@author 六叶草
 * 创建时间：2023年05月21日 16:45
 */
package com.example.springbootdemo.config.xss;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月21日 16:45
 * 项目名称:  SpringBootDemo
 * 文件名称:  XssFilter
 * 文件描述:  @Description: 前端路径过滤器
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@WebFilter(urlPatterns = "/*")
public class XssFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        XssHttpServletRequestWrapper wrapper=new XssHttpServletRequestWrapper(request);
        filterChain.doFilter(wrapper,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
