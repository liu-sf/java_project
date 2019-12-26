package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*
Filter:过滤器
1.概念：
    web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊功能
    作用：
        * 一般用于完成通用的操作。如：登录验证，统一编码处理，敏感字符处理等。
2.快速入门：
    1、步骤：
        1.定义一个类，实现接口Filter
        2.复写方法
        3.配置拦截路径
            1.web.xml
            2.注解（常用）
 */
@WebFilter("/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1被执行了。。。。");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
