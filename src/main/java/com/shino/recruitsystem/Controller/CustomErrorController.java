package com.shino.recruitsystem.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    // 状态码和对应页面的map映射
    private final static Map<Integer, String> codePageMap = new HashMap<>(){
        {
            put(403,"/error/403_page");
        }
    };

    @RequestMapping(value = ERROR_PATH, produces = MediaType.TEXT_HTML_VALUE)
    public String errorView(HttpServletRequest request) {

        // 从request对象中获取状态码
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        request.setAttribute("statusCode", "错误状态码：" + status);

        if (ObjectUtils.isEmpty(status)) {
            return this.getDefaultView();
        }

        // 若状态码包含在map映射中,就返回到指定的错误页面
        Integer statusCode = Integer.valueOf(status.toString());
        if (codePageMap.containsKey(statusCode)) {
            return codePageMap.get(statusCode);
        }

        return this.getDefaultView();
    }

    // 默认的页面
    private String getDefaultView() {
        return codePageMap.get(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
