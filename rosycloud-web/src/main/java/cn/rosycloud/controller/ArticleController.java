package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.CurrentUser;
import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.ArticleService;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 博文表 前端控制器
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Reference
    private ArticleService articleService;

    /**
     *  获取博文列表
     * @param params ionic3是以json格式传参的，使用@RequestBody接收
     * @param request
     * @return
     */
    @ResponseBody
    @IgnoreSecurity
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Response list(@RequestBody Map<String, Object> params, HttpServletRequest request){

        PageResult list = articleService.list(params);

        return new Response().success(list);
    }

    @ResponseBody
    @RequestMapping(value = "/self",method = RequestMethod.POST)
    public Response self(@RequestBody Map<String, Object> params, HttpServletRequest request,@CurrentUser User user){

        PageResult list = articleService.selfArticles(params,user);

        return new Response().success(list);
    }

}

