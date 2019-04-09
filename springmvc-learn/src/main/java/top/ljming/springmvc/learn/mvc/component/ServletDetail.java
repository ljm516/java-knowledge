package top.ljming.springmvc.learn.mvc.component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ServletDetail implements Servlet {

    /**
     * 容器启动时，加载web.xml, 里面配置了该servlet，首先调用 init 方法
     * @param servletConfig servletConfig
     */
    @Override
    public void init(ServletConfig servletConfig) {
        System.out.println("servlet init");
        String paramValue = servletConfig.getInitParameter("hello");
        String contextPath = servletConfig.getServletContext().getContextPath();
        System.out.println("paramValue: " + paramValue + ", contextPath: " + contextPath);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("do service");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String parameter = request.getParameter("name");
        String attribute = (String) request.getAttribute("name");  // request 的attribute属性一般在容器内传递

        System.out.println("parameter: " + parameter + "\n attribute: " + attribute);

    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    /**
     * 容器停止时调用
     */
    @Override
    public void destroy() {
        System.out.println("servlet destroy");
    }
}
