package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Type;
import cn.rosycloud.mapper.TypeMapper;
import cn.rosycloud.service.TypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * 类型表 服务实现类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
