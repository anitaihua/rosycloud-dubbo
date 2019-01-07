package cn.rosycloud.authorization.manager;

/**        
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 * @author yangdaihua       
 * @created 2017年7月4日 下午4:41:43    
 */

import cn.rosycloud.model.TokenModel;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(Long userId);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication);

    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(Long userId);

}
