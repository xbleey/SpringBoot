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


    @Test
    public void contextLoads() {
       char[] nameArray = "胡俊豪".toCharArray();
       for(int i =0; i<nameArray.length;i++){
           if(String.valueOf(nameArray[i]).matches("[\u4e00-\u9fa5]")){
               System.out.println("yes");
           }
       }
        //logger.info(String.valueOf(zh));
    }

}

