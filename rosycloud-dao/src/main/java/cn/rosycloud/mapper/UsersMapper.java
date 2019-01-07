package cn.rosycloud.mapper;

import cn.rosycloud.pojo.Users;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangdaihua
 * @since 2019-01-07
 */
public interface UsersMapper extends BaseMapper<Users> {

    Users findUserByUnameAndPasswd(Users u);

    List<Users> getUsers();
}
