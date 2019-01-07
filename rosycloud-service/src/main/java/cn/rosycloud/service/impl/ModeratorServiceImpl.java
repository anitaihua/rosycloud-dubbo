package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Moderator;
import cn.rosycloud.mapper.ModeratorMapper;
import cn.rosycloud.service.ModeratorService;
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
public class ModeratorServiceImpl extends ServiceImpl<ModeratorMapper, Moderator> implements ModeratorService {

}
