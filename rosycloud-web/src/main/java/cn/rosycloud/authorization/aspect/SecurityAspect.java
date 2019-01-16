package cn.rosycloud.authorization.aspect;

import java.lang.reflect.Method;

import cn.rosycloud.model.TokenModel;
import cn.rosycloud.authorization.manager.TokenManager;
import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.config.Constants;
import cn.rosycloud.utils.Response;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Title:安全检查切面(是否登录检查) 
 * Description: 通过验证Token维持登录状态
 * 
 * @author yangdaihua
 * @created 2017年7月4日 下午4:32:34
 */
@Component
@Aspect
public class SecurityAspect {

	/** Log4j日志处理(@author yangdaihua) */
	private static final Logger log = Logger.getLogger(SecurityAspect.class);

	@Autowired
	private TokenManager tokenManager;


	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object execute(ProceedingJoinPoint pjp) throws Throwable {
		// 从切点上获取目标方法
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		log.debug("methodSignature : " + methodSignature);
		Method method = methodSignature.getMethod();
		log.debug("Method : " + method.getName() + " : "
				+ method.isAnnotationPresent(IgnoreSecurity.class));
		// 若目标方法忽略了安全性检查,则直接调用目标方法
		if (method.isAnnotationPresent(IgnoreSecurity.class)) {
			return pjp.proceed();
		}

		// 从 request header 中获取当前 token
		String token = WebContextUtil.getRequest().getHeader(
				Constants.DEFAULT_TOKEN_NAME);
		//验证token
		TokenModel model = tokenManager.getToken(token);
		// 检查 token 有效性
		if (!tokenManager.checkToken(model)) {
			String message = String.format("token [%s] is invalid", token);
			log.debug("message : " + message);
			return Response.error(601,message);
		}
		// 调用目标方法
		return pjp.proceed();
	}
}
