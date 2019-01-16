package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Log;
import cn.rosycloud.mapper.LogMapper;
import cn.rosycloud.pojo.PageResult;
import cn.rosycloud.service.LogService;
import cn.rosycloud.utils.Query;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Map;

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

    @Override
    public PageResult list(Map<String, Object> params) {
        Page<Log> page = new Page<Log>();

        page = this.selectPage(new Query<Log>(params).getPage(),new EntityWrapper<>());

        return new PageResult(page.getTotal(),page.getRecords());
    }
}
