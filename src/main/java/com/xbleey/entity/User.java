/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: User
 * Author:   11580
 * Date:     2019/5/12 0012 13:21
 * Description: User
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.entity;


import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈User〉
 *
 * @author 11580
 * @create 2019/5/12 0012
 * @since 1.0.0
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", unique = true)
        
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;
    @Column(name = "user_level")
    private Integer userLevel;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }
}
 

