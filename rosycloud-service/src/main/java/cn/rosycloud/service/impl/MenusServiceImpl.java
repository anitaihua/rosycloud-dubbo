package cn.rosycloud.service.impl;

import cn.rosycloud.pojo.Menus;
import cn.rosycloud.mapper.MenusMapper;
import cn.rosycloud.service.MenusService;
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
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements MenusService {

}
