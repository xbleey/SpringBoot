/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserService
 * Author:   11580
 * Date:     2019/5/12 0012 13:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.service;

import com.xbleey.dao.UserDao;
import com.xbleey.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 11580
 * @create 2019/5/12 0012
 * @since 1.0.0
 */
@Service
public class UserService {
    @Resource
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User getOneUserByUserId(Integer userId) {
        List<User> users = userDao.getByUserId(userId);
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public void updateUser(User user) {
        userDao.updateUserByUserId(user.getUserName(), user.getUserPass(), user.getUserLevel(), user.getUserId());
    }

    public void deleteUser(Integer userId) {
        userDao.deleteById(userId);
    }
}
 

