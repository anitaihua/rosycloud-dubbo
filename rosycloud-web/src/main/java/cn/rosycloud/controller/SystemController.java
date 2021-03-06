package cn.rosycloud.controller;


import cn.rosycloud.authorization.annotation.CurrentUser;
import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.config.Constants;
import cn.rosycloud.config.HttpStatusCode;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.utils.LogUtils;
import cn.rosycloud.utils.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统公共路由
 * @author yangdaihua
 * @since 2019-01-22
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Reference
    private SystemService systemService;

    private static final Logger log = Logger.getLogger(SystemController.class);

    /**
     *  文件通用上传（上传到fastdfs服务器）
     * @param file
     * @param request
     //* @param user 当前登陆用户
     * @return
     */
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    @IgnoreSecurity
    public Response uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,@CurrentUser User user){
        Map<String,Object> result = new HashMap<String, Object>();
        //获取真实文件名字
        String name = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File file_temp = new File(path, name);

        //判断本地临时上传目录upload是否存在，否则创建
        File dirFile = new File(path);
        if(!dirFile.exists()){
            dirFile.mkdir();
        }
        //开始存储文件
        try {
            file.transferTo(file_temp);
            String fileId = systemService.uploadFile(file_temp,name);
            log.info("文件:"+name+",上传成功! [fileId="+fileId+"]");
            systemService.addLog(LogUtils.getInstance("文件["+name+"]上传成功![fileId="+fileId+"]", Constants.Log_Type_UPLOAD,Constants.Log_Leavel_INFO),user.getUserName());
            result.put("fileId",fileId);
            return  new Response().success(result);
        }catch (Exception e){
            systemService.addLog(LogUtils.getInstance("文件["+name+"]上传失败!", Constants.Log_Type_UPLOAD,Constants.Log_Leavel_INFO),user.getUserName());
            log.error(e);
            return new Response().failure(HttpStatusCode.ERROR,"Upload Failure...");
        } finally {
            //删除本地文件
            file_temp.delete();
        }
    }

    /**
     *  删除文件通用（删除fastdfs服务器文件）
     * @param fileId
     * @param request
     //* @param user 当前登陆用户
     * @return
     */
    @RequestMapping(value = "deleteFile",method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteFile(@RequestBody String fileId, HttpServletRequest request,@CurrentUser User user){
        try {
            boolean result = systemService.deleteFile(fileId);
            if(result){
                log.info("文件:["+fileId+"],删除成功! ");
                systemService.addLog(LogUtils.getInstance("文件["+fileId+"]删除成功!", Constants.Log_Type_UPLOAD,Constants.Log_Leavel_INFO),user.getUserName());
                return  new Response().success("文件:["+fileId+"],删除成功! ");
            }else {
                log.info("文件:["+fileId+"],删除失败! ");
                systemService.addLog(LogUtils.getInstance("文件["+fileId+"]删除失败!", Constants.Log_Type_UPLOAD,Constants.Log_Leavel_INFO),user.getUserName());
                return  new Response().success("文件:["+fileId+"],删除失败! ");
            }


        }catch (Exception e){
            systemService.addLog(LogUtils.getInstance("文件["+fileId+"]删除失败!", Constants.Log_Type_UPLOAD,Constants.Log_Leavel_INFO),user.getUserName());
            log.error(e);
            return new Response().failure(HttpStatusCode.ERROR,"Delete File Failure...");
        }
    }

}

