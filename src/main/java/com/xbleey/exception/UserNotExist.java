/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserNotExist
 * Author:   11580
 * Date:     2019/5/20 0020 14:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.exception;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 11580
 * @create 2019/5/20 0020
 * @since 1.0.0
 */
public class UserNotExist extends RuntimeException {
    public UserNotExist() {
        super("用户不存在");
    }
}
 

