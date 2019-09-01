/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserDao
 * Author:   11580
 * Date:     2019/5/12 0012 13:11
 * Description: userdao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.dao;


import com.xbleey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈userdao〉
 *
 * @author 11580
 * @create 2019/5/12 0012
 * @since 1.0.0
 */
public interface UserDao extends JpaRepository<User, Integer> {
    public List<User> getByUserId(Integer userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update user e set user_name=?1, user_pass =?2, user_level=?3 where user_id = ?4", nativeQuery = true)
    public int updateUserByUserId(String userName, String userPass, Integer userLevel, Integer userId);

}
 

