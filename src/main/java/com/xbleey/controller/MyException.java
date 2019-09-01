/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyException
 * Author:   11580
 * Date:     2019/5/20 0020 14:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.controller;

import com.xbleey.exception.UserNotExist;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 11580
 * @create 2019/5/20 0020
 * @since 1.0.0
 */
@ControllerAdvice
public class MyException {

    //@ResponseBody
    @ExceptionHandler(UserNotExist.class)
    public String handleException(Exception e, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 501);
        hashMap.put("code", "user.notExist");
        hashMap.put("message", e.getMessage());
        hashMap.put("exception", e.getClass());
        request.setAttribute("expt", hashMap);
        return "forward:/error";
        //return hashMap;
    }
}
 

