package com.xbleey;

import com.xbleey.entity.User;
import com.xbleey.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        List<User> users = userService.findAll();
        logger.info(users.toString());
        System.out.println("hxt am the fat pig");
    }

}
