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

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
//        User user = new User();
//        user.setUserId(1);
//        user.setUserName("good");
//        user.setUserPass("123");
//        user.setUserLevel(12);
//        userService.updateUser(user);
        List<User> users = userService.findAll();
        logger.info(users.toString());

    }

    @Test
    public void testDruid() {
        System.out.println(dataSource.getClass());
    }


}
