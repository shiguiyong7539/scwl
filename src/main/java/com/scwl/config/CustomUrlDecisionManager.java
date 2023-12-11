package com.scwl.config;

import com.alibaba.fastjson.JSONPath;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwl.pojo.Role;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 判断用户角色
 *
 * @author stone
 * @since 1.0.0
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		for (ConfigAttribute configAttribute : configAttributes) {
			//当前url所需角色
			String needRole = configAttribute.getAttribute();
			//判断角色是否登录即可访问的角色，此角色在CustomFilter中设置
			if ("ROLE_LOGIN".equals(needRole)){
				//判断是否登录
				if (authentication instanceof AnonymousAuthenticationToken){
					throw new AccessDeniedException("尚未登录，请登录！");
				}else {
					return;
				}
			}
			//判断用户角色是否为url所需角色
//			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
////			for (GrantedAuthority authority : authorities) {
////				if (authority.getAuthority().equals(needRole)){
////					return;
////				}
////			}
			Object principal = authentication.getPrincipal();
			Gson gson = new Gson();
			String json = gson.toJson(principal);
			String roles = JSONPath.read(json,"roles").toString();
			Type listType = new TypeToken<List<Role>>() {}.getType();
			List<Role> roleList = gson.fromJson(roles, listType);
			for (Role role : roleList) {
				if(needRole.equals(role.getName())){
					return;
				}
			}



		}
		throw new AccessDeniedException("沒有权限，请联系管理员!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}