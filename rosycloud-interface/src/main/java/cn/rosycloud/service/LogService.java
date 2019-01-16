package cn.rosycloud.service;

import cn.rosycloud.pojo.Log;
import cn.rosycloud.pojo.PageResult;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
public interface LogService extends IService<Log> {

    PageResult list(Map<String, Object> params);
}
