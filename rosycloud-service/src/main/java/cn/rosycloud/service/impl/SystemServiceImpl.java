package cn.rosycloud.service.impl;

import cn.rosycloud.mapper.LogMapper;
import cn.rosycloud.pojo.Log;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.service.UserService;
import cn.rosycloud.utils.FastDFSClient;
import cn.rosycloud.utils.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;


@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private UserService userService;

    @Override
    public void addLog(Log log) {

        if(log!=null&&log.getUserId()!=null){
            User u = userService.selectById(log.getUserId());
            if(u!=null){
                log.setUserName(u.getUserName());
                log.setRealName(u.getRealName());
            }else{
                log.setUserName(log.getNote());
                log.setRealName(log.getNote());
            }
            logMapper.insert(log);

        }
    }

    @Override
    public void addLog(Log log, String userName) {
        if(log!=null){
            User u = userService.selectById(log.getUserId());
            if(u!=null){
                log.setUserName(u.getUserName());
                log.setRealName(u.getRealName());
            }else{
                if(StringUtil.isNotEmpty(userName)){
                   u =  userService.selectOne(new EntityWrapper<User>().eq("user_name",userName));
                    if(u!=null){
                        log.setUserId(u.getUserId());
                        log.setUserName(u.getUserName());
                        log.setRealName(u.getRealName());
                    }
                }else{
                    log.setUserName(log.getNote());
                    log.setRealName(log.getNote());
                }
            }
            logMapper.insert(log);
        }

    }

    @Override
    public String uploadFile(File file, String filename) {
        if(!file.exists()||StringUtil.isEmpty(filename)) return "";
        return  FastDFSClient.uploadFile(file, filename);
    }

    @Override
    public String uploadFile(File file) {
        if(!file.exists()) return "";
        return  FastDFSClient.uploadFile(file, file.getName());
    }

    @Override
    public boolean deleteFile(String fileId) {
        int result = FastDFSClient.deleteFile(fileId);
        return result == 0;
    }
}
