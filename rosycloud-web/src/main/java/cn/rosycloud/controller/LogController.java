package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.service.LogService;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Reference
    private LogService logService;

    /**
     * 获取日志列表
     * @param params ionic3是以json格式传参的，使用@RequestBody接收
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Response list(@RequestBody Map<String, Object> params, HttpServletRequest request){

        PageResult list = logService.list(params);

        return new Response().success(list);
    }

}

