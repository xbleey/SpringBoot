/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyErrorAttribute
 * Author:   11580
 * Date:     2019/5/20 0020 14:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.compent;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 11580
 * @create 2019/5/20 0020
 * @since 1.0.0
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        if (webRequest.getAttribute("expt", 0) != null) {
            Map<String, Object> expt = (Map<String, Object>) webRequest.getAttribute("expt", 0);
            map.putAll(expt);
        }
        return map;
    }
}
 

