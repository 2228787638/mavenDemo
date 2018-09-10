package com.how2java.interceptor;

import com.how2java.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/9/10.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URI = {"/user/gotologin","/user/login","/user/register","/user/goToRegister"};

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
        throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion --> ");
    }

    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception{
        System.out.println("AuthorizationInterceptor postHandle -->");
    }

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthorizationInterceptor preHandler -->");
        boolean flag = false;
        String servletPath = request.getServletPath();
        for(String s : IGNORE_URI) {
            if (servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            User user = (User) request.getSession().getAttribute("user");
            HttpSession session = request.getSession();
            ServletContext application = session.getServletContext();
            if(user == null||application.getAttribute(session.getId()) == null){
                System.out.println("AuthorizationInterceptor拦截请求: ");
                //request.setAttribute("message", "请先登录再访问网站");
                request.getRequestDispatcher("../user/gotologin").forward(request, response);
            }else{
                System.out.println("AuthorizationInterceptor放行请求: ");
                flag = true;
            }
        }
        return flag;
    }
}
