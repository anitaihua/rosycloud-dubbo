package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Labels;
import cn.rosycloud.mapper.LabelsMapper;
import cn.rosycloud.service.LabelsService;
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
public class LabelsServiceImpl extends ServiceImpl<LabelsMapper, Labels> implements LabelsService {

}
