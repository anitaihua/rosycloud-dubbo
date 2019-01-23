package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Concern;
import cn.rosycloud.mapper.ConcernMapper;
import cn.rosycloud.service.ConcernService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@Service
public class ConcernServiceImpl extends ServiceImpl<ConcernMapper, Concern> implements ConcernService {

}
