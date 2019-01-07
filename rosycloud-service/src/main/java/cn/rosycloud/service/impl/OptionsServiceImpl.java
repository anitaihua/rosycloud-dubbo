package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Options;
import cn.rosycloud.mapper.OptionsMapper;
import cn.rosycloud.service.OptionsService;
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
public class OptionsServiceImpl extends ServiceImpl<OptionsMapper, Options> implements OptionsService {

}
