package com.scwl.config;


import com.scwl.pojo.Menu;
import com.scwl.pojo.Role;
import com.scwl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url分析请求所需的角色
 *
 * @author stone
 * @since 1.0.0
 */
@Component
@Order(3)
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private MenuService menuService;

	AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		//获取请求的url
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		String method = ((FilterInvocation) object).getRequest().getMethod();
		int queryStartIndex = requestUrl.indexOf('?');
		if (queryStartIndex != -1) {
			requestUrl = requestUrl.substring(0, queryStartIndex);
		}
		List<Menu> menus = menuService.getMenusWithRole();
		for (Menu menu : menus) {
			//判断请求url与菜单角色是否匹配
			if (antPathMatcher.match(menu.getUrl(),requestUrl)){
				String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
				return SecurityConfig.createList(str);
				//匹配的url默认即可访问
			//	return SecurityConfig.createList("ROLE_LOGIN");
			}
		}
		//没匹配的url默认登录可访问
		if(method.equals("GET")){
			return SecurityConfig.createList("ROLE_LOGIN");
		}
		return SecurityConfig.createList("ROLE_");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}