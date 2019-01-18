package cn.rosycloud.controller;

import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.authorization.annotation.SerializedField;
import cn.rosycloud.config.Constants;
import cn.rosycloud.pojo.Users;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.service.UsersService;
import cn.rosycloud.utils.AESOperator;
import cn.rosycloud.utils.LogUtils;
import cn.rosycloud.utils.Response;
import cn.rosycloud.utils.ValidationUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UsersController {
    
    private static String massage;

    @Reference
    private UsersService usersService;
    @Reference
    private SystemService systemService;

    @IgnoreSecurity
    @SerializedField
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json")
    public Response list() {
        List<Users> list = usersService.getUsers();

        return new Response().success(list);

    }


    @SerializedField
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.PUT,produces = "application/json")
    public Response addUser(@RequestBody @Valid Users users, BindingResult result){
        if(result.hasErrors()){
            FieldError fieldError= result.getFieldError();
            massage = ValidationUtils.getDefaultMessage(fieldError);
            return new Response().failure(massage);
        }
        try {
            usersService.insert(users);
            systemService.addLog(LogUtils.getInstance("["+users.getUserName()+"]用户添加成功", Constants.Log_Type_INSERT,Constants.Log_Leavel_INFO));
        }catch (Exception e){
            e.printStackTrace();
            return new Response().failure("网络问题，请稍后再试");
        }

        return new Response().success();
    }

    @IgnoreSecurity
    @RequestMapping(value = "/index",method = RequestMethod.GET,produces = "application/json")
    public String index() {
        return "index";

    }

}
