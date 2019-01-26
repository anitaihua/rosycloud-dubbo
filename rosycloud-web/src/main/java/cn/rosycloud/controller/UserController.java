package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.CurrentUser;
import cn.rosycloud.config.Constants;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.service.UserService;
import cn.rosycloud.utils.LogUtils;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Reference
    private SystemService systemService;

    private static final Logger log = Logger.getLogger(UserController.class);
    /**
     *  查询当前登陆人信息（待优化）
     * @param user
     * @return
     */
    @RequestMapping(value = "info",method = RequestMethod.GET)
    public Response info(@CurrentUser User user){
        user.setPassword("************");
        return new Response().success(user);
    }

    /**
     * 修改当前登陆人头像
     * @param fileId
     * @param user
     * @return
     */
    @RequestMapping(value = "updateLogo",method = RequestMethod.POST)
    public Response updateLogo(@RequestBody String fileId, @CurrentUser User user){
        try {
            userService.updateLogo(user,fileId);
            systemService.addLog(LogUtils.getInstance("修改当前登陆人头像成功!fileId=["+fileId+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            return new Response().success("用户头像更新成功");
        }catch (Exception e){
            systemService.addLog(LogUtils.getInstance("修改当前登陆人头像失败!fileId=["+fileId+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            log.error(e);
            return new Response().failure("用户头像更新失败");
        }
    }

    /**
     * 修改当前登陆人背景图片
     * @param fileId
     * @param user
     * @return
     */
    @RequestMapping(value = "updateBackgroundPhoto",method = RequestMethod.POST)
    public Response updateBackgroundPhoto(@RequestBody String fileId, @CurrentUser User user){
        try {
            userService.updateBackgroundPhoto(user,fileId);
            systemService.addLog(LogUtils.getInstance("修改当前登陆人背景图片成功!fileId=["+fileId+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            return new Response().success("用户背景图片更新成功");
        }catch (Exception e){
            systemService.addLog(LogUtils.getInstance("修改当前登陆人背景图片失败!fileId=["+fileId+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            log.error(e);
            return new Response().failure("用户背景图片更新失败");
        }

    }

    /**
     * 修改当前登陆人昵称
     * @param nickName
     * @param user
     * @return
     */
    @RequestMapping(value = "updateNickName",method = RequestMethod.POST)
    public Response updateNickName(@RequestBody String nickName, @CurrentUser User user){
        try {
            userService.updateNickName(user,nickName);
            systemService.addLog(LogUtils.getInstance("修改昵称成功!nickName=["+nickName+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            return new Response().success("用户昵称更新成功");
        }catch (Exception e){
            systemService.addLog(LogUtils.getInstance("修改昵称失败!nickName=["+nickName+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            log.error(e);
            return new Response().failure("用户昵称更新失败");
        }
    }

    /**
     * 修改当前登陆人简介
     * @param introduction
     * @param user
     * @return
     */
    @RequestMapping(value = "updateIntroduction",method = RequestMethod.POST)
    public Response updateIntroduction(@RequestBody String introduction, @CurrentUser User user){
        try {
            userService.updateIntroduction(user,introduction);
            systemService.addLog(LogUtils.getInstance("修改简介成功!introduction=["+introduction+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            return new Response().success("用户简介更新成功");
        }catch (Exception e){
            systemService.addLog(LogUtils.getInstance("修改简介失败!introduction=["+introduction+"]", Constants.Log_Type_UPDATE,Constants.Log_Leavel_INFO),user.getUserName());
            log.error(e);
            return new Response().failure("用户简介更新失败");
        }
    }

}

