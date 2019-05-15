/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   11580
 * Date:     2019/5/9 0009 10:22
 * Description: controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.controller;

import com.xbleey.entity.User;
import com.xbleey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈controller〉
 *
 * @author 11580
 * @create 2019/5/9 0009
 * @since 1.0.0
 */
@Controller
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index")
    public String go(Model model) {
        List<User> users =userService.findAll();
        model.addAttribute("users",users);
        return "index";
    }

    @PostMapping(value = "/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(Model model, @RequestParam("username") String userName, @RequestParam("password") String password, HttpSession session){
        if(!StringUtils.isEmpty(userName)&&"123".equals(password)){
            session.setAttribute("loginUser",userName);
            return go(model);
        }
        else {
            model.addAttribute("message","登录失败");
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("name","123");
        return "hello";
    }
}
 

