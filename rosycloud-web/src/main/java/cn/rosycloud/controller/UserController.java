package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.CurrentUser;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.UserService;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping(value = "info",method = RequestMethod.GET)
    public Response info(@CurrentUser User user){
        return new Response().success(user);
    }

}

