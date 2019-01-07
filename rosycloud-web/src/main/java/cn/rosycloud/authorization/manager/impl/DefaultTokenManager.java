package cn.rosycloud.authorization.manager.impl;

import cn.rosycloud.authorization.manager.TokenManager;
import cn.rosycloud.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * Title: TokenManager的默认实现    
 * Description: 管理 Token
 * @author yangdaihua       
 * @created 2017年7月4日 下午4:41:32    
 */
@Component
public class DefaultTokenManager implements TokenManager {


	private RedisTemplate<Long, String> redis;

	@Autowired
	public void setRedis(RedisTemplate redis) {
		this.redis = redis;
		//泛型设置成Long后必须更改对应的序列化方案
		RedisSerializer redisSerializer = new StringRedisSerializer();
		redis.setKeySerializer(new JdkSerializationRedisSerializer());
		redis.setValueSerializer(redisSerializer);
	}

	public TokenModel createToken(Long userId) {
		//使用uuid作为源token
		String token = UUID.randomUUID().toString().replace("-", "");
		TokenModel model = new TokenModel(userId, token);


		//存储到redis并设置过期时间
		redis.boundValueOps(userId).set(token);
		return model;
	}

	public TokenModel getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
			return null;
		}
		String[] param = authentication.split("_");
		if (param.length != 2) {
			return null;
		}
		//使用userId和源token简单拼接成的token，可以增加加密措施
		Long userId = Long.valueOf(param[0]);
		String token = param[1];
		return new TokenModel(userId, token);
	}

	public boolean checkToken(TokenModel model) {
		if (model == null) {
			return false;
		}
		String token = redis.boundValueOps(model.getUserId()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
        /*//如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);*/
		return true;
	}

	public void deleteToken(Long userId) {
		redis.delete(userId);
	}
}
