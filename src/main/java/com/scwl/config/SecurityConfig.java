package com.scwl.config;
import com.scwl.pojo.User;
import com.scwl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * Security配置类
 *
 * @author stone
 * @since 1.0.0
 */
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
	private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

	@Autowired
	private RestAuthorizationEntryPoint restAuthorizationEntryPoint;
	@Autowired
	private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
	@Autowired
	private CustomFilter customFilter;
	@Autowired
	private CustomUrlDecisionManager customUrlDecisionManager;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	//放行资源路径
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/",
				"/memberList",
				"/login",
				"/logout",
				"/admin",
				"/userInfo",
				"/index",
				"/file/**",
				"/css/**",
				"/js/**",
				"/assets/**",
				"/bootstrap/**",
				"/fonts/**",
				"/picture/**",
				"/images/**",
				"/page/**"
		);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/**").permitAll()
//				.anyRequest().authenticated()
//				.and().httpBasic();
////		//使用JWT，不需要csrf
		http.csrf()
				.disable()
				//基于token，不需要session
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				//允许访问
				//.antMatchers("/login","/temTest2","/logout")
				//.permitAll()
				//除了上面的所有请求都要求认证
				.anyRequest()
				.authenticated()
				//动态权限配置
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(O object) {
						object.setAccessDecisionManager(customUrlDecisionManager);
						object.setSecurityMetadataSource(customFilter);
						return object;
					}
				})
				.and()
				//禁用缓存
				.headers()
				.cacheControl();
		//添加jwt 登录授权过滤器
		http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		//添加自定义未授权和未登录结果返回
		http.exceptionHandling()
				.accessDeniedHandler(restfulAccessDeniedHandler)
				.authenticationEntryPoint(restAuthorizationEntryPoint);
		//记住我
		http.rememberMe()
				.rememberMeParameter("rememberMe")
				.tokenValiditySeconds(60 * 60 * 24)
				.userDetailsService(userDetailsService);
	}

	@Override
	@Bean
	public UserDetailsService userDetailsService(){
		return username -> {
			User user = userService.getAdminByUserName(username);
			if (null!=user){
				user.setRoles(userService.getRoles(user.getId()));
				return user;
			}
			throw new UsernameNotFoundException("用户名或密码不正确");
		};
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthencationTokenFilter authencationTokenFilter(){
		return new JwtAuthencationTokenFilter();
	}

	@Bean
	public JwtAuthencationTokenFilter jwtAuthencationTokenFilter(){
		return new JwtAuthencationTokenFilter();
	}

}