package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Log;
import cn.rosycloud.mapper.LogMapper;
import cn.rosycloud.service.LogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
