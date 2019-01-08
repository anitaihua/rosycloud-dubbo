package cn.rosycloud.controller;

import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.pojo.Users;
import cn.rosycloud.service.UsersService;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Reference
    private UsersService usersService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Response list(){
        List<Users> list = usersService.getUsers();
        return Response.ok().put("list",list);
    }


}
