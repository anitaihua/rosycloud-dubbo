package cn.rosycloud.utils;

import cn.rosycloud.config.Constants;
import cn.rosycloud.pojo.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class LogUtils {


    /**
     * 初始化日志信息
     * 根据token信息获取用户信息，获取用户访问的ip、浏览器信息等
     * @param LogContent
     * @param operatetype
     * @param loglevel
     * @return
     */
    public static Log getInstance(String LogContent, Integer operatetype, Integer loglevel){

        HttpServletRequest request = ContextHolderUtils.getRequest();
        String broswer = BrowserUtils.checkBrowse(request);

        Log log = new Log();
        log.setLogContent(LogContent);
        log.setLogLevel(loglevel);
        log.setOperateType(operatetype);
        log.setNote(IpUtil.getIpAddr(request));
        log.setBroswer(broswer);
        log.setOperateTime(new Date());

        // 从 request header 中获取当前 token
        String authentication = request.getHeader(
                Constants.DEFAULT_TOKEN_NAME);

        if (authentication == null || authentication.length() == 0) {
            return log;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return log;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        Long userId = Long.valueOf(param[0]);


        log.setUserId(userId);

        return log;
    }
}
