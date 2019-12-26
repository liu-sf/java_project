package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
1.过滤器执行流程：
    1.执行过滤器
    2.执行放行后的资源
    3.回来执行过滤器放行代码下的代码

2过滤器生命周期：
    1.init
    2.doFilter
    3.destory

3.过滤器配置详解：
    *拦截路径配置：
        1.具体资源路径：/index.jsp 只有访问index.jsp资源时，过滤器才会被执行
        2.拦截目录：/user/*  访问/user下的所有资源时，过滤器都会被执行
        3.后缀名拦截：*.jsp   访问所有后缀名为jsp资源时，过滤器被执行
        4.拦截所有资源：/* 访问所有资源时，过滤器都会被执行。


    * 拦截方式配置：资源被访问的方式
        * 注解配置：
            *设置dispatchTypes属性
                1.REQUEST:默认值，浏览器直接请求资源
                2.FORWARD:转发访问资源
                3.INCLUDE:包含访问资源
                4.ERROR:错误跳转资源
                5.ASYNC:异步访问资源

        * web.xml配置：

4.过滤器链（配置多个过滤器）
    *执行顺序：  如果有两个过滤器：过滤器1和过滤器2
        1.过滤器1
        2.过滤器2
        3.资源执行
        4.过滤器2
        5.过滤器1
     *过滤器先后顺序：
        1.注解配置：按照类名的字符串比较规则比较，值小的限制执行
            *如：AFilter和BFilter，AFilter就先执行

        2.web.xml配置：<filter-mapping>谁定义在上边，谁先执行。
 */



//@WebFilter("/*")
//浏览器直接请求资源时，该过滤器会被执行
@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo3 implements Filter {
    /**
     * 在服务器启动后，会创建filter对象，然后调用init方法，只执行一次，用于加载资源。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 每一次请求被拦截时，会执行，执行多次。
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo3被执行了。。。。");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * 在服务器关闭后，filter对象被销毁，如果服务器是正常关闭的，则会执行destory方法，只执行一次，用于释放资源。
     */
    @Override
    public void destroy() {

    }
}
