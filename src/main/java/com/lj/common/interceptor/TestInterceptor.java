package com.lj.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lj.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : liangjun
 * @ClassName : TestInterceptor
 * @Description :  测试拦截器
 * @Date : 2019/11/22 9:33
 */
@Component
public class TestInterceptor implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Result<Boolean> result  = new Result<Boolean>();
        String login = request.getHeader("login");
        if (null == login || "".equals(login)) {
            logger.error("拦截器拦截");
            result.setErrorCode("400");
            result.setErrorMsg("没有login");
            result.setSuccess(false);
            returnJson(response,result);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    /**
     * 返回json
     *
     * @param response 响应对象
     * @param object   要转换的对象
     */
    private void returnJson(HttpServletResponse response, Object object) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("test/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            String json = JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
            writer.print(json);
        } catch (IOException e) {
            logger.error("response error", e);
        }
    }
}
