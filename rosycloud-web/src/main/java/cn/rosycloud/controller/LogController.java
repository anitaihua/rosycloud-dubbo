package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.authorization.annotation.SerializedField;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.service.LogService;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @ResponseBody
    @IgnoreSecurity
    @RequestMapping("/list")
    public Response list(@RequestBody Map<String, Object> params, HttpServletRequest request){

        System.out.println(params);

        try {
            InputStream inputStream = request.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int flag = 0;
            while ((flag = inputStream.read(bytes)) > 0){
                byteArrayOutputStream.write(bytes,0,flag);
            }
            System.out.println(new String(byteArrayOutputStream.toByteArray(),request.getCharacterEncoding()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        PageResult list = logService.list(params);

        return Response.ok().put("list",list);
    }

}

