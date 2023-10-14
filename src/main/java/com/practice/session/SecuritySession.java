package com.practice.session;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecuritySession {
	
    /**
     * ユーザー名を取得する.
     * @return
     */
	public String getUsername() {
        // SecurityContextHolderから
        // org.springframework.security.core.Authenticationオブジェクトを取得
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication != null) {
            // AuthenticationオブジェクトからUserDetailsオブジェクトを取得
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                // UserDetailsオブジェクトから、ユーザ名を取得
                return ( (UserDetails) principal ).getUsername();
            }
        }
        return null;
    }
	
	/**
	 * 権限情報を取得する。
	 * @return  権限情報
	 */
	public Collection<? extends GrantedAuthority>  getAuthorities() {
        // SecurityContextHolderから
        // org.springframework.security.core.Authenticationオブジェクトを取得
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication != null) {
            // AuthenticationオブジェクトからUserDetailsオブジェクトを取得
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                // UserDetailsオブジェクトから、権限情報を取得
                return ( (UserDetails) principal ).getAuthorities();
            }
        }
        return null;
    }

}
