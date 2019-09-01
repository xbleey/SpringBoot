/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: LoginHandlerInterceptor
 * Author:   11580
 * Date:     2019/5/14 0014 22:47
 * Description: 登录拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈登录拦截器〉
 *
 * @author 11580
 * @create 2019/5/14 0014
 * @since 1.0.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            //未登录,返回登录页
            request.setAttribute("message", "无权限，请登录");
            request.getRequestDispatcher("/go").forward(request, response);
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
 

