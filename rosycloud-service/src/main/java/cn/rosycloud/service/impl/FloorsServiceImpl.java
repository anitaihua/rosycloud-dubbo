package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Floors;
import cn.rosycloud.mapper.FloorsMapper;
import cn.rosycloud.service.FloorsService;
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
public class FloorsServiceImpl extends ServiceImpl<FloorsMapper, Floors> implements FloorsService {

}
