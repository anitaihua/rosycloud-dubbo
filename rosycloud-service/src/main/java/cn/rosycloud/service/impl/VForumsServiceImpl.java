package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.VForums;
import cn.rosycloud.mapper.VForumsMapper;
import cn.rosycloud.service.VForumsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
@Service
public class VForumsServiceImpl extends ServiceImpl<VForumsMapper, VForums> implements VForumsService {

}
