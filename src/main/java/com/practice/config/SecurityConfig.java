package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.practice.code.ContorollerCode;
import com.practice.code.RoleCode;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,  HandlerMappingIntrospector introspector) throws Exception {
    	MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
    	
        http.authorizeHttpRequests(authorize -> {
                authorize
                // 下記は指定権限のみアクセス可能
	                // ユーザー切り替え
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.SWITH)).hasAnyRole(RoleCode.USER, RoleCode.ADMIN, RoleCode.STAFF)
	                // 管理者権限
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.ADMIN_MENU)).hasRole(RoleCode.ADMIN)
	                // 管理者・スタッフ権限
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.STAFF_MENU)).hasAnyRole(RoleCode.STAFF, RoleCode.ADMIN)
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.JAPAN)).hasAnyRole(RoleCode.STAFF, RoleCode.ADMIN)
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.SNGL_CLMN_PG)).hasAnyRole(RoleCode.STAFF, RoleCode.ADMIN)
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.TW_CLMN_PG)).hasAnyRole(RoleCode.STAFF, RoleCode.ADMIN)
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.USA)).hasAnyRole(RoleCode.STAFF, RoleCode.ADMIN)
	                // ユーザー権限
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.USER_MENU)).hasRole(RoleCode.USER)
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.CONTACT)).hasRole(RoleCode.USER)
	                .requestMatchers(mvcMatcherBuilder.pattern(ContorollerCode.JDBC_CONTACT)).hasRole(RoleCode.USER)
	                
                // 上記以外は権限なしでアクセス可能
                .anyRequest().permitAll();               
        })
        .formLogin(
    		formLogin -> {
    			//　すべてGETでフォワードする。
    			formLogin.loginPage(ContorollerCode.AUTH)
    			.failureUrl(ContorollerCode.AUTH_ERROR)
    			.defaultSuccessUrl(ContorollerCode.SWITH)
    			.usernameParameter("userId")
    			.passwordParameter("password");
        })
        .logout( logout -> 
	        {
	        	logout
	        	.logoutUrl(ContorollerCode.LOGOUT)
	        	.logoutSuccessUrl(ContorollerCode.AUTH);
	        }
        )
        .exceptionHandling(exception ->
        	{
        		exception.accessDeniedPage(ContorollerCode.ACCESS_DISABLE);
        	}
        );
        // セッション設定
        http.sessionManagement(session -> {
            // デフォルト設定
        	session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            // ログイン前のセッションを破棄して、新しいセッションを作成する。
            // ログイン前のオブジェクトは引き継がれない（デフォルトは引き継がれる）
            .sessionFixation().newSession()
            // 同時ログイン数
            .maximumSessions(1)
            // ログインは後勝ち（false→後勝ち）
            .maxSessionsPreventsLogin(false);
            // エラー時の処理を指定
            //.expiredSessionStrategy(new CustomSessionInformationExpiredStrategy());
        });
        return http.build();
    }
    
}
