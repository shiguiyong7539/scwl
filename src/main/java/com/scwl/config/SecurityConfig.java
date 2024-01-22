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
				"/","/loginAdmin","/memberList","/costManage","/mangeState","/login",
				"/logout","/admin","/userInfo","/index","/capitalList",
				"/contract",
				"/roleChoose",
				"/*/exportExcel",
				"/*/exportExcelTemp",
				"/userRoleChoose",
				"/getShowData",
				"/centerShowPhone",
				"/roleList",
				"/isLogin",
				"/authority",
				"/userList",
				"/risk",
				"/rectify",
				"/rectifyShow",
				"/assetList",
				"/lesseList",
				"/leaseInfolist",
				"/rentList",
				"/oaLogin",
				"/getOaToken",
				"/taskList",
				"/centerShow",
				"/file/**",
				"/css/**",
				"/js/**",
				"/assets/**",
				"/bootstrap/**",
				"/fonts/**",
				"/picture/**",
				"/images/**",
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
				//.antMatchers()
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



//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception
//	{
//		httpSecurity
//				// CSRF禁用，因为不使用session
//				.csrf().disable()
//				// 认证失败处理类
//				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//				// 基于token，所以不需要session
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				// 过滤请求
//				.authorizeRequests()
//				// 对于登录login 验证码captchaImage 允许匿名访问
//				.antMatchers("/login", "/captchaImage").anonymous()
//				.antMatchers(
//						HttpMethod.GET,
//						"/*.html",
//						"/**/*.html",
//						"/**/*.css",
//						"/**/*.js"
//				).permitAll()
//				.antMatchers("/profile/**").anonymous()
//				.antMatchers("/srm/qms/**").anonymous()
//				.antMatchers("/common/download**").anonymous()
//				.antMatchers("/common/download/resource**").anonymous()
//				.antMatchers("/swagger-ui.html").anonymous()
//				.antMatchers("/swagger-resources/**").anonymous()
//				.antMatchers("/webjars/**").anonymous()
//				.antMatchers("/*/api-docs").anonymous()
//				.antMatchers("/druid/**").anonymous()
//				.antMatchers("/flowable/**").permitAll()
//				.antMatchers("/socket/**").permitAll()
//				.antMatchers("/mywebservice/**").permitAll()
//				// 除上面外的所有请求全部需要鉴权认证
//				.anyRequest().authenticated()
//				.and()
//				.headers().frameOptions().disable();
//		httpSecurity.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
//		// 添加JWT filter
//		httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//		// 添加CORS filter
//		httpSecurity.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
//		httpSecurity.addFilterBefore(corsFilter, LogoutFilter.class);
//	}

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