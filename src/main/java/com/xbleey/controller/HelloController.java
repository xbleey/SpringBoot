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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

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
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping(value = "/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model, @RequestParam("username") String userName, @RequestParam("password") String password, HttpSession session) {
        if (!StringUtils.isEmpty(userName) && "123".equals(password)) {
            session.setAttribute("loginUser", userName);
            return go(model);
        } else {
            model.addAttribute("message", "登录失败");
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("name", "123");
        return "hello";
    }

    @PostMapping(value = "/pigtest")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String pigtest(Model model, @RequestParam("username") String userName, HttpSession session) {
        Integer pigLevel=0;
        pigLevel=70+new Random().nextInt(30);
        String res ="肥猪率为"+String.valueOf(pigLevel)+"%";
        for(int i =0; i<userName.length();i++){
            if(!String.valueOf(userName.charAt(i)).matches("[\u4e00-\u9fa5]")){
                res="请输入中文名字";
            }
        }

        //黄欣彤
        if(userName.equals("黄欣彤")){
            res="纯净无杂质的100%";
        }
        else if(userName.equals("殷卓婷")){
            res="差不多接近100%";
        }
        else if(userName.equals("黄月情")){
            res="差不多接近100%";
        }
        else if(userName.equals("钟映丽")){
            res="差不多接近100%";
        }
        else if(userName.equals("胡俊豪")){
            res="不好意思，这位不是肥猪";
        }
        model.addAttribute("result",res);
        return "result";
    }
}
 

