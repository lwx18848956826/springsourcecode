package com.spring.mvc.dispatch;

import com.alibaba.fastjson.JSON;
import com.spring.mvc.data.Data;
import com.spring.mvc.handler.Handler;
import com.spring.mvc.param.Param;
import com.spring.mvc.utils.ControllerHelper;
import com.spring.mvc.utils.HelperLoader;
import com.spring.mvc.utils.RequestHelper;
import com.spring.mvc.view.View;
import com.study.utils.BeanHelper;
import com.study.utils.ConfigHelper;
import com.study.utils.ReflectionUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 14:50
 */
@WebServlet(
        urlPatterns = {"/"},
        loadOnStartup = 0
)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化Helper类
        HelperLoader.init();
        // 获取ServletContext对象，用于注册Servlet
        ServletContext servletContext = servletConfig.getServletContext();
        // 注册处理jsp和静态资源Servlet
        registerServlet(servletContext);
    }

    /**
     * * DefaultServlet和JspServlet都是由Web容器创建
     *      * org.apache.catalina.servlets.DefaultServlet
     *      * org.apache.jasper.servlet.JspServlet
     *
     * @param servletContext
     */
    private void registerServlet(ServletContext servletContext) {
        // 动态注册JSP和Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        // 动态注册静态资源Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping("/favicon.ico");
        defaultServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestMethod = request.getMethod().toUpperCase();
        String path = request.getRealPath("/");
        String requestPath = request.getPathInfo();
        // 这里Tomcat配置路径有两种一种是"/userList",另外一种是 "/context地址/userList"
        String[] splits = requestPath.split("/");
        if(splits.length > 2){
            requestPath = "/" + splits[2];
        }

        // 根据请求获取处理器(类似SpringMVC处理器)
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if(handler != null){
            Class<?> controllerClass = handler.getControllerClass();
            Object bean = BeanHelper.getBean(controllerClass);
            // 初始化参数
            Param param = RequestHelper.createParam(request);

            // 调用请求对应的方法(类似SpringMVC处理器适配器)
            Object result;
            Method controllerMethod = handler.getControllerMethod();
            if(param == null || param.isEmpty()){
                result = ReflectionUtil.invokeMethod(bean,controllerMethod);
            }else {
                result = ReflectionUtil.invokeMethod(bean,controllerMethod,param);
            }

            // 跳转界面或者返回json数据(类似SpringMVC视图解析器)
            if(result instanceof View){
                handlerViewResult((View)result,request,response);
            }else {
                handlerDataResult((Data)result,response);
            }
        }
    }

    /**
     * 返回JSON数据
     * @param result
     * @param response
     */
    private void handlerDataResult(Data result, HttpServletResponse response) throws IOException {

        Object model = result.getModel();
        if(model != null){
            response.setContentType("application/json");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            PrintWriter writer = response.getWriter();
            String json = JSON.toJSON(model).toString();
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }

    /**
     * 跳转页面
     * @param result
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void handlerViewResult(View result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = result.getPath();
        if(StringUtils.isNotEmpty(path)){
            if(path.startsWith("/")){
                response.sendRedirect(request.getContextPath() + path);
            }else {
                // 请求转发
                Map<String,Object> model = result.getModel();
                if(MapUtils.isNotEmpty(model)){
                    model.forEach((k,v)->{request.setAttribute(k,v);});
                }
                request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request,response);
            }
        }
    }
}
