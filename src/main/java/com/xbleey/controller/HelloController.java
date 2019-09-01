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
import com.xbleey.exception.UserNotExist;
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

    @PostMapping(value = "/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model, @RequestParam("username") String userName, @RequestParam("password") String password, HttpSession session) {
        if (!StringUtils.isEmpty(userName) && "123".equals(password)) {
            session.setAttribute("loginUser", userName);
            return "index";
        } else {
            model.addAttribute("message", "登录失败");
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(Model model, @RequestParam("user") String user) {
        if (!user.equals("123")) {
            throw new UserNotExist();
        }
        model.addAttribute("user", user);
        return "hello";
    }


    @RequestMapping(value = "/emps")
    public String emp(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "emps";
    }

    //跳转添加员工页面
    @GetMapping("/emp")
    public String addEmp(Model model) {
        return "emp/add";
    }

    //处理添加请求
    @PostMapping("/emp")
    public String handleEmp(Model model, User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return "redirect:/emps";
    }

    //修改请求
    @GetMapping("/emps/{id}")
    public String editEmp(Model model, @PathVariable("id") Integer userId) {
        User user = userService.getOneUserByUserId(userId);
        model.addAttribute("user", user);
        return "emp/add";
    }

    //提交修改
    @PutMapping("/emp")
    public String updateEmp(Model model, User user) {
        userService.updateUser(user);
        return "redirect:/emps";
    }

    //提交删除请求
    @DeleteMapping("/emps/{id}")
    public String deleteEmp(Model model, @PathVariable("id") Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/emps";
    }
}
 

