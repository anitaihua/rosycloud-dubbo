package cn.rosycloud.service.impl;

import cn.rosycloud.mapper.LogMapper;
import cn.rosycloud.pojo.LogWithBLOBs;
import cn.rosycloud.pojo.Users;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.utils.BrowserUtils;
import cn.rosycloud.utils.ContextHolderUtils;
import cn.rosycloud.utils.IpUtil;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void addLog(String LogContent, Short operatetype, Short loglevel) {

        HttpServletRequest request = ContextHolderUtils.getRequest();
        String broswer = BrowserUtils.checkBrowse(request);

        LogWithBLOBs log = new LogWithBLOBs();
        log.setLogContent(LogContent);
        log.setLogLevel(loglevel);
        log.setOperateType(operatetype);
        log.setNote(IpUtil.getIpAddr(request));
        log.setBroswer(broswer);
        log.setOperateTime(new Date());
        Users u = new Users();
        if(u!=null){
            log.setUserId(u.getUserId());
            log.setUserName(u.getUserName());
            log.setRealName(u.getUserNickname());
        }
        logMapper.insert(log);
    }
}
