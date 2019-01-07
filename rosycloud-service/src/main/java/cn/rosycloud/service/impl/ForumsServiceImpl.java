package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Forums;
import cn.rosycloud.mapper.ForumsMapper;
import cn.rosycloud.service.ForumsService;
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
public class ForumsServiceImpl extends ServiceImpl<ForumsMapper, Forums> implements ForumsService {

}
