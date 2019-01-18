package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.pojo.Articles;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.service.ArticlesService;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
@RequestMapping("/articles")
public class ArticlesController {

    @Reference
    private ArticlesService articlesService;

    /**
     * 查询博文列表（支持分页参数）
     * @param params
     * @param request
     * @return
     */
    @ResponseBody
    @IgnoreSecurity
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Response list(@RequestBody Map<String, Object> params, HttpServletRequest request){

        PageResult list = articlesService.list(params);

        return new Response().success(list);
    }

    /**
     * 添加一篇新的博文
     * @param articles
     * @return
     */
    @ResponseBody
    @IgnoreSecurity
    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public Response add(@RequestBody Articles articles){

        try {
            articlesService.addArticle(articles);
        }catch (Exception e){
            e.printStackTrace();
            return new Response().failure("添加失败");
        }
        return new Response().success();
    }

    /**
     * 查看博文详情页
     * @param articleId
     * @return
     */
    @ResponseBody
    @IgnoreSecurity
    @RequestMapping(value = "/info/{articleId}",method = RequestMethod.GET)
    public Response info(@PathVariable("articleId") Long articleId){

        Articles articles = articlesService.selectById(articleId);

        return new Response().success(articles);
    }

    /**
     * 删除博文
     * @param articleId
     * @return
     */
    @ResponseBody
    @IgnoreSecurity
    @RequestMapping(value = "/del/{articleId}",method = RequestMethod.DELETE)
    public Response del(@PathVariable("articleId") Long articleId){

        try {
            articlesService.deleteById(articleId);
        }catch (Exception e){
            e.printStackTrace();
            return new Response().failure("删除失败");
        }
        return new Response().success();

    }

}

