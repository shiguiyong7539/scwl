package com.scwl.config;

import com.scwl.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * JWT登录授权过滤器
 *
 * @author stone
 * @since 1.0.0
 */
@Order(2)
public class JwtAuthencationTokenFilter extends OncePerRequestFilter {

	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authHeader = request.getHeader(tokenHeader);
		//存在token
		if (null != authHeader && authHeader.startsWith(tokenHead)) {
			String authToken = authHeader.substring(tokenHead.length());
			Claims claims = jwtTokenUtil.tokenIsExpired(authToken);
			if (null != claims) {
			String username = jwtTokenUtil.getUserNameFromToken(authToken);
			//token存在用户名但未登录
			if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
				//登录
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				//验证token是否有效，重新设置用户对象
				if (jwtTokenUtil.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authenticationToken =
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		}
		}
		filterChain.doFilter(request, response);
	}
}