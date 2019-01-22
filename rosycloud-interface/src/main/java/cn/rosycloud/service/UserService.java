package cn.rosycloud.service;

import cn.rosycloud.pojo.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-22
 */
public interface UserService extends IService<User> {

    Long login(String username, String password);
}
