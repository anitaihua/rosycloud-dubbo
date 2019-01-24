package cn.rosycloud.authorization.rosolvers;

import cn.rosycloud.authorization.annotation.CurrentUser;
import cn.rosycloud.authorization.aspect.WebContextUtil;
import cn.rosycloud.authorization.manager.TokenManager;
import cn.rosycloud.config.Constants;
import cn.rosycloud.model.TokenModel;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 增加方法注入，将含有CurrentUser注解的方法参数注入当前登录用户
 * @see cn.rosycloud.authorization.annotation.CurrentUser
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenManager tokenManager;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是User并且有CurrentUser注解则支持
        if (parameter.getParameterType().isAssignableFrom(User.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        //取出鉴权时存入的登录用户Id
        String token = WebContextUtil.getRequest().getHeader(
                Constants.DEFAULT_TOKEN_NAME);
        //验证token
        TokenModel model = tokenManager.getToken(token);
        if (model!=null && model.getUserId() != null) {
            //从数据库中查询并返回
            return userService.selectById(model.getUserId());
        }
        return null;
    }
}
