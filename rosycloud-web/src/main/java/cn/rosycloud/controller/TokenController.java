package cn.rosycloud.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rosycloud.config.HttpStatusCode;
import cn.rosycloud.model.TokenModel;
import cn.rosycloud.authorization.manager.TokenManager;
import cn.rosycloud.authorization.annotation.IgnoreSecurity;
import cn.rosycloud.config.Constants;
import cn.rosycloud.pojo.User;
import cn.rosycloud.service.SystemService;
import cn.rosycloud.service.UserService;
import cn.rosycloud.utils.LogUtils;
import cn.rosycloud.utils.Response;
import cn.rosycloud.utils.StringUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**        
 * Title: Token的管理    
 * Description: 处理用户的登录、登出操作
 * @author yangdaihua       
 * @created 2017年7月4日 下午4:52:58    
 */      
@RestController
@RequestMapping("/tokens")
public class TokenController {

	@Reference
	private UserService userService;
	@Reference
	private SystemService systemService;
	@Autowired
	private TokenManager tokenManager;

	private static final Logger log = Logger.getLogger(TokenController.class);



	  
	/**     
	 * @description 登录处理
	 * @author yangdaihua       
	 * @created 2017年7月4日 下午4:53:58     
	 */
	@RequestMapping(method = RequestMethod.POST)
	@IgnoreSecurity
	public Response login(@RequestBody Map<String, Object> params, HttpServletRequest request, @RequestParam(value = "username",required = false) String username,
						  @RequestParam(value = "password",required = false) String password, HttpServletResponse response) {
		if(StringUtil.isEmpty(username)) username = (String) params.get("username");
		if(StringUtil.isEmpty(password)) password = (String) params.get("password");

		Long flag = userService.login(username, password);
		Map<String,Object> result = new HashMap<>();
		if (flag.compareTo((long)-1)!=0) {
			TokenModel token = tokenManager.createToken(flag);
			log.debug("**** Generate Token **** : " + token);
			Cookie cookie = new Cookie(Constants.DEFAULT_TOKEN_NAME, token.getUserId()+"_"+token.getToken());
			log.debug("Write Token to Cookie and return to the Client : " + cookie.toString());
			response.addCookie(cookie);
			systemService.addLog(LogUtils.getInstance("["+username+"]登陆成功",Constants.Log_Type_LOGIN,Constants.Log_Leavel_INFO),username);
			result.put("token",token.getUserId()+"_"+token.getToken());
			return new Response().success(result);
		}
		return new Response().failure(HttpStatusCode.USERNAME_OR_PASSWORD_WRONG,"Login Failure...");
	}

	/**     
	 * @description 登出处理
	 * @author yangdaihua       
	 * @created 2017年7月4日 下午4:53:58     
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public Response logout(HttpServletRequest request) {
		String token = request.getHeader(Constants.DEFAULT_TOKEN_NAME);

		TokenModel model = tokenManager.getToken(token);
		if(tokenManager.checkToken(model)){
			User user = userService.selectById(model.getUserId());
			tokenManager.deleteToken(model.getUserId());
			log.debug("Logout Success...");
			systemService.addLog(LogUtils.getInstance("["+user.getUserName()+"]登出成功",Constants.Log_Type_EXIT,Constants.Log_Leavel_INFO));
			return new Response().success("Logout Success...");
		}else{
			return new Response().failure(HttpStatusCode.TOKEN_EXPIRE,"Logout Failure...");
		}

	}
}
